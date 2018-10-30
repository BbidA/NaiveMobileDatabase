package blservice;

import dataservice.MyBatisConfiguration;
import entity.Order;
import entity.Plan;
import entity.User;
import mapper.BasicChargeMapper;
import mapper.OrderMapper;
import mapper.PlanMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import util.MyPrinter;
import vo.PlanConsumption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public class PlanService {

    private PlanMapper planMapper;

    private OrderMapper orderMapper;

    private UserMapper userMapper;

    private BasicChargeMapper chargeMapper;

    private SqlSession session;

    public PlanService() {
        session = MyBatisConfiguration.getSessionFactory().openSession();
        planMapper = session.getMapper(PlanMapper.class);
        orderMapper = session.getMapper(OrderMapper.class);
        userMapper = session.getMapper(UserMapper.class);
        chargeMapper = session.getMapper(BasicChargeMapper.class);
    }

    public void subscribeInTime(int packageId, String phoneNumber) {

        if (userNotExists(phoneNumber))
            return;

        User user = userMapper.getByPhoneNumber(phoneNumber);
        Plan plan = planMapper.getPlan(packageId);

        // check null
        assert user != null;
        if (plan == null) {
            System.out.println("您所查询的套餐不存在，获取套餐列表请输入 list");
            return;
        }

        // check user's money
        if (user.getBalance() < plan.getExpense()) {
            System.out.println("账户余额不足，订购失败");
            return;
        }

        // record order
        Order order = Order.immediateOrder(phoneNumber, packageId);
        orderMapper.addOrder(order);

        // deduct money
        user.setBalance(user.getBalance() - plan.getExpense());
        userMapper.update(user);
        session.commit();

        System.out.println("订购成功");

    }

    public void subscribeNextMonth(int packageId, String phoneNumber) {

        if (userNotExists(phoneNumber))
            return;

        User user = userMapper.getByPhoneNumber(phoneNumber);
        Plan plan = planMapper.getPlan(packageId);

        // check null
        assert user != null;
        if (plan == null) {
            System.out.println("您所查询的套餐不存在，获取套餐列表请输入 list");
            return;
        }

        Order order = Order.nextMonthOrder(phoneNumber, packageId);
        orderMapper.addOrder(order);
        session.commit();

        System.out.println("订购成功");
    }

    public void unsubscribeInTime(int packageId, String phoneNumber) {

        if (userNotExists(phoneNumber))
            return;

        Order order = orderMapper.getByPhoneAndPlan(phoneNumber, packageId);

        if (order == null) {
            System.out.println("您所查询的订单不存在");
            return;
        }

        User user = userMapper.getByPhoneNumber(phoneNumber);
        assert user != null;

        if (order.getState() == Order.State.effective) {
            // if this order hasn't taken effect, just
            // set its state to 'out', else just
            // return all money for this plan and let
            // the user repay his consumption by basic
            // charge
            PlanConsumption consumption = getPlanConsumption(phoneNumber, packageId);
            assert consumption != null;

            double needToPay = consumption.giveMoneyByBasicCharge(chargeMapper.getCurrentCharge());
            System.out.println("退订成功！");
            System.out.println(String.format("您将获得 %.2f 元退款", consumption.getPlanOriginalExpense()));
            System.out.println(String.format("您需要额外支付 %.2f 元", needToPay));
            user.setBalance(user.getBalance() - needToPay + consumption.getPlanOriginalExpense());

            // recalculate and reset user's consumption
            updateUserConsumption(user, consumption);

            userMapper.update(user);
        } else {
            System.out.println("您的订单尚未生效，将直接退订");
        }

        orderMapper.unsubscribeImmediately(order);
        System.out.println("退订成功");
        session.commit();
    }

    private void updateUserConsumption(User user, PlanConsumption consumption) {
        user.setCallMinutes(user.getCallMinutes() - consumption.getCall());
        user.setOutPlanCall(user.getOutPlanCall() + consumption.getCall());

        user.setMessages(user.getMessages() - consumption.getMessages());
        user.setOutPlanCall(user.getOutPlanMessages() + consumption.getMessages());

        user.setLocalData(user.getLocalData() - consumption.getLocalData());
        user.setOutPlanLocalData(user.getOutPlanLocalData() + consumption.getDomesticData());

        user.setDomesticData(user.getDomesticData() - consumption.getDomesticData());
        user.setOutPlanDomesticData(user.getOutPlanDomesticData() + consumption.getDomesticData());
    }

    public void unsubscribeNextMonth(int packageId, String phoneNumber) {
        if (userNotExists(phoneNumber))
            return;

        Order order = orderMapper.getByPhoneAndPlan(phoneNumber, packageId);

        if (order == null) {
            System.out.println("您所查询的订单不存在");
            return;
        }

        if (order.getState() == Order.State.waiting_effective) {
            System.out.println("您的订单还未生效，将直接退订");
            orderMapper.unsubscribeImmediately(order);
            System.out.println("退订成功");
        } else {
            orderMapper.unsubscribeNextMonth(order);
            System.out.println("您的订单已经成功退订，下月生效");
        }
        session.commit();
    }

    public void orderInformation(String phoneNumber) {
        if (userNotExists(phoneNumber))
            return;

        List<Order> allOrders = orderMapper.findAllOrders(phoneNumber);

        if (allOrders.isEmpty()) {
            System.out.println("您没有订购任何套餐");
        }

        System.out.println("==========套餐订购历史记录===========");
        allOrders.stream()
                .sorted(Comparator.comparing(Order::getState).thenComparing(Order::getTime))
                .forEach(order -> {
                    System.out.println();
                    MyPrinter.printOrder(order);
                });
        System.out.println("===================================");
    }

    public void effectivePlans(String phoneNumber) {
        if (userNotExists(phoneNumber)) return;

        List<Plan> effectivePlans = planMapper.findEffectivePlans(phoneNumber);

        if (effectivePlans.isEmpty()) {
            System.out.println("您当前没有订购任何套餐");
            return;
        }

        List<PlanConsumption> consumptions = calculateConsumption(phoneNumber, effectivePlans);
        List<Order> orders = orderMapper.findCurrentlyEffectiveOrders(phoneNumber);

        assert orders.size() == consumptions.size();

        System.out.println("==========当前套餐===========");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println();
            MyPrinter.showPlanConsumption(consumptions.get(i), orders.get(i));

        }
        System.out.println("============================");
    }

    public boolean userNotExists(String phoneNumber) {
        if (userMapper.getByPhoneNumber(phoneNumber) == null) {
            System.out.println("当前用户不存在");
            return true;
        }
        return false;
    }

    public void viewPlan(int planId) {
        Plan plan = planMapper.getPlan(planId);
        if (plan == null) {
            System.out.println("当前套餐不存在");
            return;
        }
        System.out.println("==========套餐查询===========");
        MyPrinter.printPlan(planMapper.getPlan(planId));
        System.out.println("============================");
    }

    public void listAvailablePackages() {
        List<Plan> plans = planMapper.getAllPlans();
        System.out.println("==========套餐列表===========");
        for (Plan plan : plans) {
            // Print each plan's information
            System.out.println();
            MyPrinter.printPlan(plan);
            System.out.println();
        }
        System.out.println("============================");
    }

    private List<PlanConsumption> calculateConsumption(String phoneNumber, List<Plan> plans) {
        User user = userMapper.getByPhoneNumber(phoneNumber);

        int call = user.getCallMinutes();
        int message = user.getMessages();
        double localData = user.getLocalData();
        double domesticData = user.getDomesticData();

        List<PlanConsumption> result = new ArrayList<>();

        for (Plan plan : plans) {

            int planConsumedCall = 0;
            int planConsumedMessages = 0;
            double planConsumedLocalData = 0.;
            double planConsumedDomesticeData = 0.;

            if (plan.getCallMinutes() > 0) {
                planConsumedCall = plan.getCallMinutes() > call ? call : plan.getCallMinutes();
                call -= planConsumedCall;
            }

            if (plan.getMessages() > 0) {
                planConsumedMessages = plan.getMessages() > message ? message : plan.getMessages();
                message -= planConsumedMessages;
            }

            if (plan.getDomesticData() > 0) {
                planConsumedDomesticeData = plan.getDomesticData() > domesticData ?
                        domesticData : plan.getDomesticData();
                domesticData -= planConsumedDomesticeData;
            }

            if (plan.getLocalData() > 0) {
                planConsumedLocalData = plan.getLocalData() > localData ? localData : plan.getLocalData();
                localData -= planConsumedLocalData;
            }

            result.add(new PlanConsumption(plan, planConsumedLocalData, planConsumedDomesticeData,
                    planConsumedMessages, planConsumedCall));
        }

        return result;
    }

    private PlanConsumption getPlanConsumption(String phoneNumber, int planId) {
        List<Plan> effectivePlans = planMapper.findEffectivePlans(phoneNumber);
        return calculateConsumption(phoneNumber, effectivePlans)
                .stream().filter(c -> c.getPlan().getId() == planId)
                .findFirst().orElseThrow();
    }

}
