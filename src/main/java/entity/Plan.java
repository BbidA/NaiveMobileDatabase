package entity;

import java.util.Objects;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class Plan {

    private Integer id;

    private Double expense;

    private Integer callMinutes;

    private Integer messages;

    private Double localData;

    private Double domesticData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
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
}
