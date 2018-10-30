package vo;

import entity.BasicCharge;
import entity.Plan;

/**
 * Author: J.D. Liao
 * Date: 2018/10/29
 * Description:
 */
public class PlanConsumption {

    private Plan plan;

    private Double localData;

    private Double domesticData;

    private Integer messages;

    private Integer call;

    public PlanConsumption(Plan plan, Double localData, Double domesticData,
                           Integer messages, Integer call) {
        this.plan = plan;
        this.localData = localData;
        this.domesticData = domesticData;
        this.messages = messages;
        this.call = call;
    }

    public double giveMoneyByBasicCharge(BasicCharge basicCharge) {
        return localData * basicCharge.getLocalDataCharge()
                + domesticData * basicCharge.getDomesticDataCharge()
                + messages * basicCharge.getMessageCharge()
                + call * basicCharge.getCallCharge();
    }

    public double getPlanOriginalExpense() {
        return plan.getExpense();
    }

    public Plan getPlan() {
        return plan;
    }

    public Double getLocalData() {
        return localData;
    }

    public Double getDomesticData() {
        return domesticData;
    }

    public Integer getMessages() {
        return messages;
    }

    public Integer getCall() {
        return call;
    }
}
