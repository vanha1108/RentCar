package com.store.rent.car.mapper;

import com.store.rent.car.dto.ContractDetailDTO;
import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.enity.Partner;
import com.store.rent.car.enity.PartnerContract;

public class DTOMapper {

    public static PartnerDetailDTO toPartnerDetailDTO(Partner partner) {
        PartnerDetailDTO dto = new PartnerDetailDTO();
        if (partner == null){
            return null;
        }
        dto.setId(partner.getId());
        dto.setName(partner.getName());
        dto.setAddress(partner.getAddress());
        dto.setPhone(partner.getPhone());
        dto.setNote(partner.getNote());
        return dto;
    }

    public static ContractDetailDTO toContractDetailDTO(PartnerContract partnerContract) {
        ContractDetailDTO dto = new ContractDetailDTO();
        if (partnerContract == null){
            return null;
        }
        dto.setId(partnerContract.getId());
        dto.setStartDate(partnerContract.getStartDate());
        dto.setEndDate(partnerContract.getEndDate());
        return dto;
    }
}
