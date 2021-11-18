package com.store.rent.car.service;

import com.store.rent.car.dto.ContractDetailDTO;
import com.store.rent.car.dto.PartnerDetailDTO;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    List<PartnerDetailDTO> getStatistic(Date fromDate, Date toDate);

    List<ContractDetailDTO> statisticDetails(Long idPartner, Date fromDate, Date toDate);
}
