package blservice;

import dataservice.MyBatisConfiguration;
import entity.CallExpense;
import entity.DataExpense;
import entity.Plan;
import entity.User;
import mapper.BasicChargeMapper;
import mapper.ExpensesMapper;
import mapper.PlanMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import util.MyPrinter;
import vo.MonthlyBill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public class BillService {

    private UserMapper userMapper;

    private SqlSession session;

    private ExpensesMapper expensesMapper;

    private PlanMapper planMapper;

    private BasicChargeMapper chargeMapper;

    public BillService() {
        session = MyBatisConfiguration.getSessionFactory().openSession();
        userMapper = session.getMapper(UserMapper.class);
        expensesMapper = session.getMapper(ExpensesMapper.class);
        planMapper = session.getMapper(PlanMapper.class);
        chargeMapper = session.getMapper(BasicChargeMapper.class);
    }

    public void showCallBills(int months, String phoneNumber) {

        Map<String, Object> result = getParametersMap(months, phoneNumber);

        List<CallExpense> callExpenses = expensesMapper.getCallExpensesInRecentMonths(result);
        System.out.println(String.format("%s %33s %6s", "时间", "通话时长/分钟", "计费/元"));
        for (CallExpense expense : callExpenses) {
            MyPrinter.printCallExpenses(expense);
        }
    }

    public void showDataBills(int months, String phoneNumber) {
        Map<String, Object> result = getParametersMap(months, phoneNumber);

        System.out.println(String.format("%-19s %-25s %-8s %-9s %-10s", "开始时间", "结束时间", "套餐类型", "使用", "计费/元"));
        List<DataExpense> dataExpenses = expensesMapper.getDataExpensesInRecentMonths(result);
        for (DataExpense expense : dataExpenses) {
            MyPrinter.printDataExpenses(expense);

        }
    }

    private Map<String, Object> getParametersMap(int months, String phoneNumber) {
        Map<String, Object> result = new HashMap<>();
        result.put("months", months);
        result.put("userPhone", phoneNumber);
        return result;
    }

    public void showMonthBill(String phoneNumber) {
        User user = userMapper.getByPhoneNumber(phoneNumber);
        List<Plan> plans = planMapper.findEffectivePlans(phoneNumber);

        System.out.println("============本月账单===========");

        System.out.println(new MonthlyBill(plans, user).describe(chargeMapper.getCurrentCharge()));

        System.out.println("==============================  ");
    }
}
