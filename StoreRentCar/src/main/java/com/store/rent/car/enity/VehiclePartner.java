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

    @Column(name = "so_luong")
    private Integer amount;

    @Column(name = "don_gia")
    private BigDecimal price;
}
