package com.store.rent.car.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ContractDetailDTO {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer countVehicle;
    private BigDecimal violateMoney;
    private BigDecimal totalMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountVehicle() {
        return countVehicle;
    }

    public void setCountVehicle(Integer countVehicle) {
        this.countVehicle = countVehicle;
    }

    public BigDecimal getViolateMoney() {
        return violateMoney;
    }

    public void setViolateMoney(BigDecimal violateMoney) {
        this.violateMoney = violateMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
