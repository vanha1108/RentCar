package com.store.rent.car.service;

import com.store.rent.car.dao.PartnerContractDAO;
import com.store.rent.car.enity.PartnerContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PartnerContractServiceImpl implements PartnerContractService {

    @Autowired
    PartnerContractDAO partnerContractDAO;

    @Override
    public List<PartnerContract> findStartDateBetween(Date fromDate, Date toDate) {
        return partnerContractDAO.findStartDateBetween(fromDate, toDate);
    }

    @Override
    public List<PartnerContract> findByIdPartnerStartDateBetween(Long idPartner, Date fromDate, Date toDate) {
        return partnerContractDAO.findByIdPartnerStartDateBetween(idPartner, fromDate, toDate);
    }

    @Override
    public List<PartnerContract> findByIdPartner(Long idPartner) {
        return partnerContractDAO.findByIdPartner(idPartner);
    }
}
