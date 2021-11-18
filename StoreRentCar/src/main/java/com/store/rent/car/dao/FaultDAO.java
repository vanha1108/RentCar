package com.store.rent.car.dao;

import com.store.rent.car.enity.Fault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultDAO extends JpaRepository<Fault, Long> {
}
