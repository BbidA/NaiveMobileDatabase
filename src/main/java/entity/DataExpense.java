package entity;

import java.time.LocalDateTime;

/**
 * Author: J.D. Liao
 * Date: 2018/10/30
 * Description:
 */
public class DataExpense {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double dataConsumption;

    private Type type;

    private Double expense;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getDataConsumption() {
        return dataConsumption;
    }

    public void setDataConsumption(Double dataConsumption) {
        this.dataConsumption = dataConsumption;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public static enum Type {
        Domestic,
        Local
    }
}
