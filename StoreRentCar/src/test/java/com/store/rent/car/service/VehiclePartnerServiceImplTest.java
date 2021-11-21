package com.store.rent.car.service;

import com.store.rent.car.dao.VehiclePartnerDAO;
import com.store.rent.car.enity.VehiclePartner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VehiclePartnerServiceImplTest {

    @InjectMocks VehiclePartnerServiceImpl vehiclePartnerService;

    @Mock VehiclePartnerDAO vehiclePartnerDAO;

    @Test
    public void testFindByIdPartnerContract() {
        Mockito.when(vehiclePartnerDAO.findByIdPartnerContract(0L)).thenReturn(new VehiclePartner());
        Assert.assertNotNull(vehiclePartnerService.findByIdPartnerContract(0L));
    }
}