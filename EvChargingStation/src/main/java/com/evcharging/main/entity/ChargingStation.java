package com.evcharging.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHARGING_STATIONS")
public class ChargingStation {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int station_id;
	private String station_name;
	@Column(nullable = true, length = 64)
	private String station_image;
	private float station_pricing;
	private String station_address;
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public float getStation_pricing() {
		return station_pricing;
	}
	public void setStation_pricing(float station_pricing) {
		this.station_pricing = station_pricing;
	}
	public String getStation_address() {
		return station_address;
	}
	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}
	public String getStation_image() {
		return station_image;
	}
	public void setStation_image(String station_image) {
		this.station_image = station_image;
	}
	public ChargingStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChargingStation(String station_name, String station_image, float station_pricing, String station_address) {
		super();
		this.station_name = station_name;
		this.station_image = station_image;
		this.station_pricing = station_pricing;
		this.station_address = station_address;
	}
	@Override
	public String toString() {
		return "ChargingStation [station_id=" + station_id + ", station_name=" + station_name + ", station_image="
				+ station_image + ", station_pricing=" + station_pricing + ", station_address=" + station_address + "]";
	}
	
	
}
