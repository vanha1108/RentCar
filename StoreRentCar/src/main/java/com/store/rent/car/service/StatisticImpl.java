package com.store.rent.car.service;

import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.enity.Partner;
import com.store.rent.car.enity.PartnerContract;
import com.store.rent.car.mapper.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatisticImpl implements StatisticService {

    @Autowired
    PartnerService partnerService;

    @Autowired
    PartnerContractService partnerContractService;

    @Autowired
    VehiclePartnerService vehiclePartnerService;

    @Override
    public List<PartnerDetailDTO> getStatistic(Date fromDate, Date toDate) {
        List<PartnerDetailDTO> partnerDetailDTOS = new ArrayList<>();
        List<PartnerContract> partnerContracts = partnerContractService.findStartDateBetween(fromDate, toDate);
        if (partnerContracts == null || partnerContracts.size() <= 0) {
            return new ArrayList<>();
        }
        for (PartnerContract partnerContract : partnerContracts) {
            Partner partner = partnerService.findById(partnerContract.getIdPartner());
            PartnerDetailDTO partnerDetailDTO = DTOMapper.toPartnerDetailDTO(partner);
            if (partnerDetailDTO != null) {
                List<PartnerContract> partnerContractList = partnerContractService.findByIdPartner(partnerContract.getIdPartner());
                if (partnerContractList != null && partnerContractList.size() > 0) {
                    int countDate = 0;
                    BigDecimal revenues = BigDecimal.ZERO;
                    for (PartnerContract contract : partnerContractList) {
                        revenues = revenues.add(new BigDecimal(contract.getValue()));
                        countDate += Math.abs(ChronoUnit.DAYS.between(contract.getEndDate().toInstant(), contract.getStartDate().toInstant()));
                    }
                    partnerDetailDTO.setCountDate(countDate);
                    partnerDetailDTO.setRevenues(revenues);
                    partnerDetailDTO.setTurns(partnerContractList.size());
                }
            }
            partnerDetailDTOS.add(partnerDetailDTO);
        }
        return partnerDetailDTOS;
    }

    @Override
    public PartnerDetailDTO statisticDetails(Long idPartner) {
        Partner partner = partnerService.findById(idPartner);
        if (partner == null) {
            return null;
        }
        PartnerDetailDTO partnerDetailDTO = DTOMapper.toPartnerDetailDTO(partner);
        if (partnerDetailDTO != null) {
            List<PartnerContract> partnerContractList = partnerContractService.findByIdPartner(idPartner);
            if (partnerContractList != null && partnerContractList.size() > 0) {
                int countDate = 0;
                BigDecimal revenues = BigDecimal.ZERO;
                for (PartnerContract contract : partnerContractList) {
                    revenues = revenues.add(new BigDecimal(contract.getValue()));
                    countDate += Math.abs(ChronoUnit.DAYS.between(contract.getEndDate().toInstant(), contract.getStartDate().toInstant()));
                }
                partnerDetailDTO.setCountDate(countDate);
                partnerDetailDTO.setRevenues(revenues);
                partnerDetailDTO.setTurns(partnerContractList.size());
            }
        }
        return partnerDetailDTO;
    }
}
