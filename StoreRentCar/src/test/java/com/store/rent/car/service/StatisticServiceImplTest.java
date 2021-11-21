package com.store.rent.car.service;


import com.store.rent.car.enity.Fault;
import com.store.rent.car.enity.Partner;
import com.store.rent.car.enity.PartnerContract;
import com.store.rent.car.enity.VehiclePartner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceImplTest {

    @InjectMocks
    StatisticServiceImpl statisticService;

    @Mock PartnerService partnerService;

    @Mock PartnerContractService partnerContractService;

    @Mock VehiclePartnerService vehiclePartnerService;

    @Mock FaultService faultService;


    @Test
    public void testGetStatisticForSizeIsNull() {
        Date date = new Date();
        Assert.assertEquals(0, statisticService.getStatistic(date, date).size());
    }

    @Test
    public void testGetStatistic() {
        Date date = new Date();
        PartnerContract partnerContract = new PartnerContract();
        partnerContract.setId(0L);
        partnerContract.setValue("100000");
        partnerContract.setIdPartner(0L);
        partnerContract.setStartDate(date);
        partnerContract.setEndDate(new Date(2021, 11, 15));
        Partner partner = new Partner();
        VehiclePartner vehiclePartner = new VehiclePartner();
        vehiclePartner.setIdFault(0L);
        Fault fault = new Fault();
        fault.setValue(new BigDecimal("1000000"));

        Mockito.when(partnerContractService.findStartDateBetween(date, date)).thenReturn(Collections.singletonList(partnerContract));
        Mockito.when(partnerService.findById(partnerContract.getIdPartner())).thenReturn(partner);
        Mockito.when(vehiclePartnerService.findByIdPartnerContract(partnerContract.getIdPartner())).thenReturn(vehiclePartner);
        Mockito.when(faultService.findById(vehiclePartner.getIdFault())).thenReturn(fault);

        Assert.assertEquals(1, statisticService.getStatistic(date, date).size());
    }

    @Test
    public void testStatisticDetailsForNull() {
        Date date = new Date();
        Assert.assertNull(statisticService.statisticDetails(0L, date, date));
    }

    @Test
    public void testStatisticDetails() {
        Date date = new Date();
        PartnerContract partnerContract = new PartnerContract();
        partnerContract.setId(0L);
        partnerContract.setValue("100000");
        partnerContract.setIdPartner(0L);
        partnerContract.setStartDate(date);
        partnerContract.setEndDate(new Date(2021, 11, 15));
        VehiclePartner vehiclePartner = new VehiclePartner();
        vehiclePartner.setIdFault(0L);
        vehiclePartner.setAmount(2);
        Partner partner = new Partner();
        Fault fault = new Fault();
        fault.setValue(new BigDecimal("1000000"));

        Mockito.when(partnerContractService.findByIdPartnerStartDateBetween(0L, date, date)).thenReturn(Collections.singletonList(partnerContract));
        Mockito.when(vehiclePartnerService.findByIdPartnerContract(partnerContract.getIdPartner())).thenReturn(vehiclePartner);
        Mockito.when(partnerService.findById(partnerContract.getIdPartner())).thenReturn(partner);
        Mockito.when(faultService.findById(vehiclePartner.getIdFault())).thenReturn(fault);

        Assert.assertEquals(1, statisticService.statisticDetails(0L, date, date).size());
    }
}