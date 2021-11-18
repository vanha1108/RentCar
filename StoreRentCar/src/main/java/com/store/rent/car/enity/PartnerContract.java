package com.store.rent.car.enity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hop_dong_thue_xe_dt")
public class PartnerContract {
    @Id
    private Long id;

    @Column(name = "id_dt")
    private Long idPartner;

    @Column(name = "id_nhan_vien")
    private Long idEmployee;

    @Column(name = "ma_hd")
    private String code;

    @Column(name = "noi_dung_hop_dong")
    private String content;

    @Column(name = "gia_tri_thue")
    private String value;

    @Column(name = "ngay_bat_dau")
    private Date startDate;

    @Column(name = "ngay_het_han")
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(Long idPartner) {
        this.idPartner = idPartner;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
}
