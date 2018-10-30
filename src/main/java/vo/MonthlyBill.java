package vo;

import entity.BasicCharge;
import entity.Plan;
import entity.User;
import util.MyFormatter;

import java.util.List;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public class MonthlyBill {

    private List<Plan> orderedPlans;

    private Integer usedCallMinutes;

    private Integer usedMessages;

    private Double usedLocalData;

    private Double usedDomesticData;

    private Double balance;

    private Integer outCall;

    private Integer outMessages;

    private Double outLocalData;

    private Double outDomesticData;

    public MonthlyBill(List<Plan> orderedPlans, User user) {
        this.orderedPlans = orderedPlans;
        this.usedCallMinutes = user.getCallMinutes();
        this.usedMessages = user.getMessages();
        this.usedLocalData = user.getLocalData();
        this.usedDomesticData = user.getDomesticData();
        this.balance = user.getBalance();
        this.outCall = user.getOutPlanCall();
        this.outMessages = user.getOutPlanMessages();
        this.outLocalData = user.getOutPlanLocalData();
        this.outDomesticData = user.getOutPlanDomesticData();
    }

    public String describe(BasicCharge charge) {
        // Calculate and print what plans has offered
        double totalLocalData = 0;
        double totalDomesticData = 0;
        int totalCallMinutes = 0;
        int totalMessages = 0;
        double totalPlanExpenses = 0.;
        for (Plan plan : orderedPlans) {
            totalCallMinutes += plan.getCallMinutes();
            totalMessages += plan.getMessages();
            totalDomesticData += plan.getDomesticData();
            totalLocalData += plan.getLocalData();
            totalPlanExpenses += plan.getExpense();
        }

        double outLocalDataFee = outLocalData * charge.getLocalDataCharge();
        double outDomesticDataFee = outDomesticData * charge.getDomesticDataCharge();
        double outCallFee = outCall * charge.getCallCharge();
        double outMessagesFee = outMessages * charge.getMessageCharge();
        double totalExpense = outLocalDataFee + outDomesticDataFee + outCallFee + outMessagesFee + totalPlanExpenses;


        return "本月总共通话 " + usedCallMinutes + " 分钟\n" +
                "套餐内剩余通话：" + Math.max(0, totalCallMinutes - usedCallMinutes) + " 分钟\n" +
                "套餐外通话：" + outCall + " 分钟\n" +
                "总共使用流量：" + MyFormatter.formatData(usedDomesticData + usedLocalData) + " \n" +
                "使用本地流量：" + MyFormatter.formatData(usedLocalData) + " \n" +
                "剩余本地流量：" + MyFormatter.formatData(Math.max(0, totalLocalData - usedLocalData)) + " \n" +
                "套餐外本地流量：" + MyFormatter.formatData(outLocalData) + "\n" +
                "使用全国流量：" + MyFormatter.formatData(usedDomesticData) + "\n" +
                "剩余全国流量：" + MyFormatter.formatData(Math.max(0, totalDomesticData - usedDomesticData)) + " \n" +
                "套餐外全国流量：" + MyFormatter.formatData(outDomesticData) + "\n" +
                "发送短信：" + usedMessages + " 条\n" +
                "剩余短信：" + Math.max(0, totalMessages - usedMessages) + " 条\n" +
                "额外本地流量费用：" + outLocalDataFee + " 元\n" +
                "额外全国流量费用：" + outDomesticDataFee + " 元\n" +
                "额外通话费用：" + outCallFee + " 元\n" +
                "额外短信费用：" + outMessagesFee + " 元\n" +
                "套餐费：" + totalPlanExpenses + " 元\n" +
                "月总消费：" + totalExpense + " 元\n" +
                "用户余额：" + balance + " 元";

    }
}
