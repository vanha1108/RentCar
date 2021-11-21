package com.store.rent.car.service;

import com.store.rent.car.dao.PartnerDAO;
import com.store.rent.car.enity.Partner;
import com.store.rent.car.enity.PartnerContract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PartnerServiceImplTest {

    @InjectMocks PartnerServiceImpl partnerService;

    @Mock
    PartnerDAO partnerDAO;

    @Test
    public void testFindAll() {
        Mockito.when(partnerDAO.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(partnerService.findAll());
    }

    @Test
    public void testFindById() {
        Assert.assertNull(partnerService.findById(0L));
    }

    @Test
    public void testFindByIdForNotNull() {
        Mockito.when(partnerDAO.findById(0L)).thenReturn(Optional.of(new Partner()));
        Assert.assertNotNull((partnerService.findById(0L)));
    }
}
