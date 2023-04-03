package com.evcharging.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evcharging.main.entity.ChargingStation;
import com.evcharging.main.repository.EvStationRepository;

@RestController
public class EvStationController {

	@Autowired
	EvStationRepository station;
	
	@GetMapping("/stations")
	public List<ChargingStation> getAllStations(){
		List<ChargingStation> allstations = station.findAll();
		List<ChargingStation> result = new ArrayList<>();
		for(int i=0;i<allstations.size() && i<10;i++) {
			result.add(allstations.get(i));
		}
		return result;
	}
	@GetMapping("/stations/show/{id}")
	public ChargingStation getStationById(@PathVariable(value = "id") int station_id) {
		return station.findById(station_id).get();
	}
	
	@PostMapping("/")
	public String addStation(@RequestBody ChargingStation cs) {
		station.save(cs);
		return "Station added successfully!";
	}
	@DeleteMapping("/stations/delete/{id}")
	public String deleteStation(@PathVariable(value = "id") int station_id) {
		station.deleteById(station_id);
		return "Deleted Successfully!";
	}
	@PutMapping("/{id}/edit")
	public String editStationById(@PathVariable(value = "id") int station_id, @RequestBody ChargingStation cs) {
		ChargingStation cs_old = station.findById(station_id).get();
		if(Objects.nonNull(cs.getStation_name()) && !"".equalsIgnoreCase(cs.getStation_name())) {
			  cs_old.setStation_name(cs.getStation_name());
		  }
		  if(Objects.nonNull(cs.getStation_image()) && !"".equalsIgnoreCase(cs.getStation_image())) {
			  cs_old.setStation_image(cs.getStation_image());
			  }
		 if(Objects.nonNull(cs.getStation_pricing()) && cs.getStation_pricing()!=cs_old.getStation_pricing()) {
			 cs_old.setStation_pricing(cs.getStation_pricing());
			 }
		 if(Objects.nonNull(cs.getStation_address()) && !"".equalsIgnoreCase(cs.getStation_address())) {
			 cs_old.setStation_address(cs.getStation_address());
			 }
		 station.save(cs_old);
		return "Edited Successfully!";
	}
}
