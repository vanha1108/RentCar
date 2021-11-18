package com.store.rent.car.service;

import com.store.rent.car.enity.PartnerContract;

import java.util.Date;
import java.util.List;

public interface PartnerContractService {
    List<PartnerContract> findStartDateBetween(Date fromDate, Date toDate);

    List<PartnerContract> findByIdPartnerStartDateBetween(Long idPartner, Date fromDate, Date toDate);

    List<PartnerContract> findByIdPartner(Long idPartner);
}
