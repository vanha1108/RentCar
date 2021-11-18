package com.store.rent.car.controller;

import com.store.rent.car.dto.InputStatisticDTO;
import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    StatisticService service;

    @PostMapping
    public ResponseEntity<?> statistic(@RequestBody InputStatisticDTO input) throws ParseException {
        if (input == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(input.getFromDate());
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(input.getToDate());
        List<PartnerDetailDTO> partnerDetailDTOS = service.getStatistic(from, to);
        return new ResponseEntity<>(partnerDetailDTOS, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> statisticDetails(@PathVariable("id") String idPartner, @RequestBody InputStatisticDTO input) throws ParseException {
        if (input == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(input.getFromDate());
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(input.getToDate());
        return new ResponseEntity<>(service.statisticDetails(Long.parseLong(idPartner), from, to), HttpStatus.OK);
    }
}
