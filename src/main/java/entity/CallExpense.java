package entity;

import java.time.LocalDateTime;

/**
 * Author: J.D. Liao
 * Date: 2018/10/30
 * Description:
 */
public class CallExpense {

    private LocalDateTime startTime;

    private Integer duration;

    private Double expense;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
