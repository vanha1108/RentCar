package com.store.rent.car.service;

import com.store.rent.car.dao.PartnerContractDAO;
import com.store.rent.car.enity.PartnerContract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PartnerContractServiceImplTest {

    @InjectMocks PartnerContractServiceImpl partnerContractService;

    @Mock
    PartnerContractDAO partnerContractDAO;

    @Test
    public void testFindById() {
        Assert.assertNull(partnerContractService.findById(0L));
    }

    @Test
    public void testFindByIdForNotNull() {
        Mockito.when(partnerContractDAO.findById(0L)).thenReturn(Optional.of(new PartnerContract()));
        Assert.assertNotNull((partnerContractService.findById(0L)));
    }

    @Test
    public void testFindStartDateBetween() {
        Date date = new Date();
        Mockito.when(partnerContractDAO.findStartDateBetween(date, date)).thenReturn(Collections.singletonList(new PartnerContract()));
        Assert.assertNotNull(partnerContractService.findStartDateBetween(date, date));
    }

    @Test
    public void testFindByIdPartnerStartDateBetween() {
        Date date = new Date();
        Mockito.when(partnerContractDAO.findByIdPartnerStartDateBetween(0L, date, date)).thenReturn(Collections.singletonList(new PartnerContract()));
        Assert.assertNotNull(partnerContractService.findByIdPartnerStartDateBetween(0L, date, date));
    }

    @Test
    public void testFindByIdPartner() {
        Mockito.when(partnerContractDAO.findByIdPartner(0L)).thenReturn(Collections.singletonList(new PartnerContract()));
        Assert.assertNotNull(partnerContractService.findByIdPartner(0L));
    }
}