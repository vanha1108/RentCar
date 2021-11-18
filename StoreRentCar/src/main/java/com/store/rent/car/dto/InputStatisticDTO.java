package com.store.rent.car.dto;

import java.io.Serializable;

public class InputStatisticDTO implements Serializable {
    String fromDate;
    String toDate;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
