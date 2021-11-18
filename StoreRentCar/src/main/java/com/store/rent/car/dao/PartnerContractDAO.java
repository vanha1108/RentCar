package com.store.rent.car.dao;

import com.store.rent.car.enity.PartnerContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PartnerContractDAO extends JpaRepository<PartnerContract, Long> {

    @Query(value = "SELECT * from hop_dong_thue_xe_dt hd where hd.id_dt = :idPartner and hd.ngay_bat_dau >= :fromDate and hd.ngay_bat_dau <= :toDate", nativeQuery = true)
    List<PartnerContract> findByIdPartnerStartDateBetween(Long idPartner, Date fromDate, Date toDate);

    @Query(value = "SELECT * from hop_dong_thue_xe_dt hd where hd.ngay_bat_dau >= :fromDate and hd.ngay_bat_dau <= :toDate", nativeQuery = true)
    List<PartnerContract> findStartDateBetween(Date fromDate, Date toDate);

    @Query(value = "SELECT * from hop_dong_thue_xe_dt hd where hd.id_dt = :id", nativeQuery = true)
    List<PartnerContract> findByIdPartner(Long id);
}
