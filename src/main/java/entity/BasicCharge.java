package entity;

import java.time.LocalDate;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class BasicCharge {

    private Integer id;

    private Double localDataCharge;

    private Double domesticDataCharge;

    private Double callCharge;

    private Double messageCharge;

    private LocalDate effectiveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLocalDataCharge() {
        return localDataCharge;
    }

    public void setLocalDataCharge(Double localDataCharge) {
        this.localDataCharge = localDataCharge;
    }

    public Double getDomesticDataCharge() {
        return domesticDataCharge;
    }

    public void setDomesticDataCharge(Double domesticDataCharge) {
        this.domesticDataCharge = domesticDataCharge;
    }

    public Double getCallCharge() {
        return callCharge;
    }

    public void setCallCharge(Double callCharge) {
        this.callCharge = callCharge;
    }

    public Double getMessageCharge() {
        return messageCharge;
    }

    public void setMessageCharge(Double messageCharge) {
        this.messageCharge = messageCharge;
    }

    public LocalDate getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(LocalDate effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
