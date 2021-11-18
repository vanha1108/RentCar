package com.store.rent.car.service;

import com.store.rent.car.dao.FaultDAO;
import com.store.rent.car.enity.Fault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaultServiceImpl implements FaultService {

    @Autowired
    FaultDAO faultDAO;

    @Override
    public Fault findById(Long id) {
        Optional<Fault> optionalFault = faultDAO.findById(id);
        if (optionalFault.isPresent()) {
            return optionalFault.get();
        }
        return null;
    }
}
