package com.store.rent.car.service;

import com.store.rent.car.dao.FaultDAO;
import com.store.rent.car.enity.Fault;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FaultServiceImplTest {

    @InjectMocks FaultServiceImpl faultService;

    @Mock
    FaultDAO faultDAO;

    @Test
    public void testFindById() {
        Assert.assertNull(faultService.findById(0L));
    }

    @Test
    public void testFindByIdForNotNull() {
        Mockito.when(faultDAO.findById(0L)).thenReturn(Optional.of(new Fault()));
        Assert.assertNotNull((faultService.findById(0L)));
    }
}