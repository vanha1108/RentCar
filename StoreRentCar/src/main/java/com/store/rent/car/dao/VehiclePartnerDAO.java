package com.store.rent.car.dao;

import com.store.rent.car.enity.VehiclePartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehiclePartnerDAO extends JpaRepository<VehiclePartner, Long> {

    @Query(value = "SELECT * from xe_thue_dt v WHERE v.id_hop_dong = :idContract", nativeQuery = true)
    VehiclePartner findByIdPartnerContract(Long idContract);
}
