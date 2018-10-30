package entity;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class Expenses {

    private String phoneNumber;

    private Integer callMinutes;

    private Integer messages;

    private Double localData;

    private Double domesticData;

    private Double expense;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCallMinutes() {
        return callMinutes;
    }

    public void setCallMinutes(Integer callMinutes) {
        this.callMinutes = callMinutes;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Double getLocalData() {
        return localData;
    }

    public void setLocalData(Double localData) {
        this.localData = localData;
    }

    public Double getDomesticData() {
        return domesticData;
    }

    public void setDomesticData(Double domesticData) {
        this.domesticData = domesticData;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
