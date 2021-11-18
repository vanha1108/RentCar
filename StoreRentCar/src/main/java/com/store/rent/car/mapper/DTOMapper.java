package com.store.rent.car.mapper;

import com.store.rent.car.dto.PartnerDetailDTO;
import com.store.rent.car.enity.Partner;

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
}
