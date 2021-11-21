package com.store.rent.car.service;

import com.store.rent.car.dao.PartnerContractDAO;
import com.store.rent.car.enity.PartnerContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerContractServiceImpl implements PartnerContractService {

    @Autowired
    PartnerContractDAO partnerContractDAO;

    @Override
    public PartnerContract findById(Long idContract) {
        Optional<PartnerContract> optionalPartnerContract = partnerContractDAO.findById(idContract);
        if (optionalPartnerContract.isPresent()) {
            return optionalPartnerContract.get();
        }
        return null;
    }

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
