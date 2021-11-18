package com.store.rent.car.service;

import com.store.rent.car.dto.ContractDetailDTO;
import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.enity.Fault;
import com.store.rent.car.enity.Partner;
import com.store.rent.car.enity.PartnerContract;
import com.store.rent.car.enity.VehiclePartner;
import com.store.rent.car.mapper.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class StatisticImpl implements StatisticService {

    @Autowired
    PartnerService partnerService;

    @Autowired
    PartnerContractService partnerContractService;

    @Autowired
    VehiclePartnerService vehiclePartnerService;

    @Autowired
    FaultService faultService;

    @Override
    public List<PartnerDetailDTO> getStatistic(Date fromDate, Date toDate) {
        Map<Long, PartnerDetailDTO> map = new HashMap<>();
        List<PartnerDetailDTO> partnerDetailDTOS = new ArrayList<>();
        List<PartnerContract> partnerContracts = partnerContractService.findStartDateBetween(fromDate, toDate);
        if (partnerContracts == null || partnerContracts.size() <= 0) {
            return new ArrayList<>();
        }
        for (PartnerContract partnerContract : partnerContracts) {
            Partner partner = partnerService.findById(partnerContract.getIdPartner());
            PartnerDetailDTO partnerDetailDTO = DTOMapper.toPartnerDetailDTO(partner);
            if (partnerDetailDTO != null) {
                int countDate = 0;
                BigDecimal revenues = BigDecimal.ZERO;
                List<PartnerContract> partnerContractList = partnerContractService.findByIdPartner(partnerContract.getIdPartner());
                if (partnerContractList != null && partnerContractList.size() > 0) {
                    for (PartnerContract contract : partnerContractList) {
                        revenues = revenues.add(new BigDecimal(contract.getValue()));
                        countDate += Math.abs(ChronoUnit.DAYS.between(contract.getEndDate().toInstant(), contract.getStartDate().toInstant()));
                    }
                    if(map.containsKey(partner.getId())) {
                        partnerDetailDTO = map.get(partner.getId());
                        partnerDetailDTO.setCountDate(partnerDetailDTO.getCountDate() + countDate);
                        partnerDetailDTO.setRevenues(partnerDetailDTO.getRevenues().add(revenues));
                    } else {
                        partnerDetailDTO.setCountDate(countDate);
                        partnerDetailDTO.setRevenues(revenues);
                        partnerDetailDTO.setTurns(partnerContractList.size());
                    }
                    map.put(partner.getId(), partnerDetailDTO);
                }
            }
        }
        map.forEach((k, v) -> partnerDetailDTOS.add(v));
        return partnerDetailDTOS;
    }

    @Override
    public List<ContractDetailDTO> statisticDetails(Long idPartner, Date fromDate, Date toDate) {
        List<ContractDetailDTO> contractDetailDTOS = new ArrayList<>();

        List<PartnerContract> partnerContractList = partnerContractService.findByIdPartnerStartDateBetween(idPartner, fromDate, toDate);
        if(partnerContractList == null || partnerContractList.size() <= 0) {
            return null;
        }
        for(PartnerContract partnerContract: partnerContractList) {
            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
             contractDetailDTO = DTOMapper.toContractDetailDTO(partnerContract);
            if (contractDetailDTO != null) {
                VehiclePartner vehiclePartner = vehiclePartnerService.findByIdPartnerContract(partnerContract.getId());
                Partner partner = partnerService.findById(partnerContract.getIdPartner());
                Fault fault = faultService.findById(vehiclePartner.getIdFault());
                if (fault != null) {
                    contractDetailDTO.setViolateMoney(fault.getValue());
                }
                if(partner != null) {
                    contractDetailDTO.setName(partner.getName());
                }
                contractDetailDTO.setCountVehicle(vehiclePartner.getAmount());
                contractDetailDTO.setTotalMoney(new BigDecimal(partnerContract.getValue()));
            }
            contractDetailDTOS.add(contractDetailDTO);
        }
        return contractDetailDTOS;
    }
}
