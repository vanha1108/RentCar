package com.store.rent.car.enity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "xe_thue_dt")
public class VehiclePartner {

    @Id
    private Long id;

    @Column(name = "id_xe")
    private Long idVehicle;

    @Column(name = "id_hop_dong")
    private Long idPartnerContract;

    @Column(name = "id_loi")
    private Long idFault;

    @Column(name = "so_luong")
    private Integer amount;

    @Column(name = "don_gia")
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Long getIdPartnerContract() {
        return idPartnerContract;
    }

    public void setIdPartnerContract(Long idPartnerContract) {
        this.idPartnerContract = idPartnerContract;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getIdFault() {
        return idFault;
    }

    public void setIdFault(Long idFault) {
        this.idFault = idFault;
    }
}
