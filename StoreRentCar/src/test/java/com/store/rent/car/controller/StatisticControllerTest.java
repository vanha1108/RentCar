package com.store.rent.car.controller;

import com.store.rent.car.dto.ContractDetailDTO;
import com.store.rent.car.dto.InputStatisticDTO;
import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.service.StatisticService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class StatisticControllerTest {

    @InjectMocks StatisticController statisticController;

    @Mock
    StatisticService service;


    @Test
    public void testStatistic() throws ParseException {
        InputStatisticDTO inputStatisticDTO = new InputStatisticDTO();
        inputStatisticDTO.setFromDate("2021-11-15");
        inputStatisticDTO.setToDate("2021-11-30");
        Mockito.when(service.getStatistic(any(), any())).thenReturn(Collections.singletonList(new PartnerDetailDTO()));
        Assert.assertNotNull(statisticController.statistic(inputStatisticDTO));
    }

    @Test
    public void testStatisticReturnBodyNull() throws ParseException {
        Assert.assertNull(statisticController.statistic(null).getBody());
    }

    @Test
    public void testStatisticDetailsReturnBodyNull() throws ParseException {
        Assert.assertNull(statisticController.statisticDetails("1", null).getBody());
    }

    @Test
    public void testStatisticDetails() throws ParseException {
        InputStatisticDTO input = new InputStatisticDTO();
        input.setFromDate("2021-11-15");
        input.setToDate("2021-11-30");
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(input.getFromDate());
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(input.getToDate());
        Mockito.when(service.statisticDetails(Long.parseLong("1"), from, to)).thenReturn(Collections.singletonList(new ContractDetailDTO()));
        Assert.assertNull(statisticController.statisticDetails("1", null).getBody());
    }
}