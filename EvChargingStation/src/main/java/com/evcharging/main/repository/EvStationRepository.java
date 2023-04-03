package com.evcharging.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evcharging.main.entity.ChargingStation;

public interface EvStationRepository extends JpaRepository<ChargingStation, Integer> {

}
