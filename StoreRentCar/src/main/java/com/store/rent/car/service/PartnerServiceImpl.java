package com.store.rent.car.service;

import com.store.rent.car.dao.PartnerDAO;
import com.store.rent.car.enity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    PartnerDAO partnerDAO;

    @Override
    public List<Partner> findAll() {
        return partnerDAO.findAll();
    }

    @Override
    public Partner findById(Long id) {
        Optional<Partner> optionalPartner = partnerDAO.findById(id);
        if (optionalPartner.isPresent()) {
            return optionalPartner.get();
        }
        return null;
    }
}
