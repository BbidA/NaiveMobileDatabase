package entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class Order {

    public static Order immediateOrder(String phoneNumber, Integer packageId) {
        return new Order(LocalDateTime.now(), State.effective, phoneNumber,
                packageId, LocalDateTime.now());
    }

    public static Order nextMonthOrder(String phoneNumber, Integer packageId) {
        return new Order(LocalDateTime.now(), State.waiting_effective, phoneNumber,
                packageId, LocalDateTime.now().plusMonths(1)
                .with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0));
    }

    private Integer id;

    private LocalDateTime time;

    private State state;

    private String userPhone;

    private Integer packageId;

    private LocalDateTime effectiveTime;

    public Order() {}

    public Order(LocalDateTime time, State state, String userPhone,
                 Integer packageId, LocalDateTime effectiveTime) {
        this.time = time;
        this.state = state;
        this.userPhone = userPhone;
        this.packageId = packageId;
        this.effectiveTime = effectiveTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time=" + time +
                ", state=" + state +
                ", userPhone='" + userPhone + '\'' +
                ", packageId=" + packageId +
                ", effectiveTime=" + effectiveTime +
                '}';
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static enum State {
        effective,
        waiting_effective,
        out,
        waiting_out
    }
}
