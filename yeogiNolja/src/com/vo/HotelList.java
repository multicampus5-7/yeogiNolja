package com.vo;

public class HotelList {
	String hotel_id;
	String hotel_name;
	String addr_sd;
	String addr_sgg;
	String addr_emd;
	int total_room;
	double lon;
	double lat;
	String amenities;
	String grade;
	String hotel_img;

	public HotelList() {
	}

	public HotelList(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public HotelList(String hotel_id, String hotel_name, String addr_sd, String addr_sgg, String addr_emd,
			int total_room, String amenities, String grade) {
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.addr_sd = addr_sd;
		this.addr_sgg = addr_sgg;
		this.addr_emd = addr_emd;
		this.total_room = total_room;
		this.amenities = amenities;
		this.grade = grade;
	}
	
	public HotelList(String hotel_id, String hotel_name, String addr_sd, String addr_sgg, String addr_emd, int total_room,
			double lon, double lat, String amenities, String grade, String hotel_img) {
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.addr_sd = addr_sd;
		this.addr_sgg = addr_sgg;
		this.addr_emd = addr_emd;
		this.total_room = total_room;
		this.lon = lon;
		this.lat = lat;
		this.amenities = amenities;
		this.grade = grade;
		this.hotel_img = hotel_img;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getName() {
		return hotel_name;
	}

	public void setName(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getAddr_sd() {
		return addr_sd;
	}

	public void setAddr_sd(String addr_sd) {
		this.addr_sd = addr_sd;
	}

	public String getAddr_sgg() {
		return addr_sgg;
	}

	public void setAddr_sgg(String addr_sgg) {
		this.addr_sgg = addr_sgg;
	}

	public String getAddr_emd() {
		return addr_emd;
	}

	public void setAddr_emd(String addr_emd) {
		this.addr_emd = addr_emd;
	}

	public int getTotal_room() {
		return total_room;
	}

	public void setTotal_room(int total_room) {
		this.total_room = total_room;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getHotel_img() {
		return hotel_img;
	}

	public void setHotel_img(String hotel_img) {
		this.hotel_img = hotel_img;
	}

	@Override
	public String toString() {
		return "HotelList [hotel_id=" + hotel_id + ", name=" + hotel_name + ", addr_sd=" + addr_sd + ", addr_sgg=" + addr_sgg
				+ ", addr_emd=" + addr_emd + ", total_room=" + total_room + ", lon=" + lon + ", lat=" + lat
				+ ", amenities=" + amenities + ", grade=" + grade + ", hotel_img=" + hotel_img + "]";
	}

}
