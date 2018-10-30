package entity;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class User {

    private String phoneNumber;

    private Integer callMinutes;

    private Integer outPlanCall;

    private Integer outPlanMessages;

    private Double outPlanLocalData;

    private Double outPlanDomesticData;

    private Integer messages;

    private Double localData;

    private Double domesticData;

    private Double balance;


    public Double getOutPlanDomesticData() {
        return outPlanDomesticData;
    }

    public void setOutPlanDomesticData(Double outPlanDomesticData) {
        this.outPlanDomesticData = outPlanDomesticData;
    }

    public Integer getOutPlanCall() {
        return outPlanCall;
    }

    public void setOutPlanCall(Integer outPlanCall) {
        this.outPlanCall = outPlanCall;
    }

    public Integer getOutPlanMessages() {
        return outPlanMessages;
    }

    public void setOutPlanMessages(Integer outPlanMessages) {
        this.outPlanMessages = outPlanMessages;
    }

    public Double getOutPlanLocalData() {
        return outPlanLocalData;
    }

    public void setOutPlanLocalData(Double outPlanLocalData) {
        this.outPlanLocalData = outPlanLocalData;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public void setCallMinutes(Integer callMinutes) {
        this.callMinutes = callMinutes;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public void setLocalData(Double localData) {
        this.localData = localData;
    }

    public void setDomesticData(Double domesticData) {
        this.domesticData = domesticData;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getCallMinutes() {
        return callMinutes;
    }

    public Integer getMessages() {
        return messages;
    }

    public Double getLocalData() {
        return localData;
    }

    public Double getDomesticData() {
        return domesticData;
    }

    public Double getBalance() {
        return balance;
    }
}
