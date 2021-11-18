package com.store.rent.car.service;

import com.store.rent.car.dao.VehiclePartnerDAO;
import com.store.rent.car.enity.VehiclePartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiclePartnerServiceImpl implements VehiclePartnerService {

    @Autowired
    VehiclePartnerDAO vehiclePartnerDAO;

    @Override
    public VehiclePartner findByIdPartnerContract(Long idContract) {
        return vehiclePartnerDAO.findByIdPartnerContract(idContract);
    }
}
