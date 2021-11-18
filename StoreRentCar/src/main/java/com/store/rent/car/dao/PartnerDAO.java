package com.store.rent.car.dao;

import com.store.rent.car.enity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerDAO extends JpaRepository<Partner, Long> {
}
