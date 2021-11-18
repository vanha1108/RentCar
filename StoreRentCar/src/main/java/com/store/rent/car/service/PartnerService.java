package com.store.rent.car.service;

import com.store.rent.car.enity.Partner;

import java.util.List;

public interface PartnerService {
    List<Partner> findAll();

    Partner findById(Long id);
}
