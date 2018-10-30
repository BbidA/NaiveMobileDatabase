package util;

import entity.CallExpense;
import entity.DataExpense;
import entity.Order;
import entity.Plan;
import vo.PlanConsumption;

/**
 * Author: J.D. Liao
 * Date: 2018/10/29
 * Description:
 */
public class MyPrinter {

    public static void printCallExpenses(CallExpense expense) {
        System.out.println(MyFormatter.formatCallExpense(expense));
    }

    public static void printDataExpenses(DataExpense expense) {
        System.out.println(MyFormatter.formatDataExpense(expense));
    }

    public static void printOrder(Order order) {
        System.out.println("套餐编号：" + order.getPackageId());
        System.out.println("状态：" + MyFormatter.formatOrderState(order.getState()));
        System.out.println("订购时间：" + MyFormatter.formatTime(order.getTime()));
        System.out.println("生效时间：" + MyFormatter.formatTime(order.getEffectiveTime()));
    }

    public static void printPlan(Plan plan) {
        System.out.println("套餐 " + plan.getId() + " :");

        System.out.printf("套餐费用 %.2f 元\n", plan.getExpense());

        if (plan.getCallMinutes() > 0)
            System.out.println("套餐提供通话时长 " + plan.getCallMinutes() + " 分钟");

        if (plan.getMessages() > 0)
            System.out.println("套餐提供短信 " + plan.getMessages() + " 条");

        if (plan.getLocalData() > 0)
            System.out.println("套餐提供本地流量 " + MyFormatter.formatData(plan.getLocalData()));

        if (plan.getDomesticData() > 0)
            System.out.println("套餐提供全国通用流量 " + MyFormatter.formatData(plan.getDomesticData()));
    }

    public static void showPlanConsumption(PlanConsumption consumption, Order planOrder) {
        Plan plan = consumption.getPlan();
        System.out.println("套餐 " + plan.getId() + " 消费情况如下：");
        System.out.println("套餐当前状态：" + MyFormatter.formatOrderState(planOrder.getState()));

        if (plan.getCallMinutes() > 0)
            System.out.println(String.format("通话使用情况 %d分钟 / %d分钟",
                    consumption.getCall(), plan.getCallMinutes()));

        if (plan.getMessages() > 0)
            System.out.println(String.format("短信使用情况 %d条 / %d条",
                    consumption.getMessages(), plan.getMessages()));

        if (plan.getLocalData() > 0)
            System.out.println("本地流量使用情况： " + MyFormatter.formatData(consumption.getLocalData())
                    + " / " + MyFormatter.formatData(plan.getLocalData()));

        if (plan.getDomesticData() > 0)
            System.out.println(("全国通用流量使用情况： " + MyFormatter.formatData(consumption.getDomesticData())
                    + " / " + MyFormatter.formatData(plan.getDomesticData())));
    }
}
