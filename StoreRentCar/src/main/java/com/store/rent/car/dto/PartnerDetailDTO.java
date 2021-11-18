package com.store.rent.car.dto;

import java.math.BigDecimal;

public class PartnerDetailDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String note;
    private Integer turns;
    private Integer countDate;
    private BigDecimal revenues;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
    }

    public Integer getCountDate() {
        return countDate;
    }

    public void setCountDate(Integer countDate) {
        this.countDate = countDate;
    }

    public BigDecimal getRevenues() {
        return revenues;
    }

    public void setRevenues(BigDecimal revenues) {
        this.revenues = revenues;
    }
}
