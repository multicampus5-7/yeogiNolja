package com.vo;

public class ReserveVO {
	// HOTEL_RESERVE
	private String rsv_id;
	private String hotel_id;
	private String room_id;
	private String user_email;
	private String start_date;
	private String end_date;
	private String rsv_date;
	private String pay_yn;

	// USERS
	private String name;
	private String admin_yn;

	// HOTEL_LIST
	private String hotel_name;
	private String addr_sd;
	private String addr_sgg;
	private String addr_emd;
	private String total_room;
	private String lon;
	private String lat;
	private String amenities;
	private String grade;
	private String hotel_img;

	// HOTEL_ROOM
	private String room_name;
	private String adults;
	private String price;
	private String room_img;
	private String room_num;

	public ReserveVO() {
	}

	public ReserveVO(String rsv_id) {
		this.rsv_id = rsv_id;
	}

	public ReserveVO(String start_date, String end_date) {
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public ReserveVO(String rsv_id, String pay_yn, String empty) {
		this.rsv_id = rsv_id;
		this.pay_yn = pay_yn;
	}

	public ReserveVO(String rsv_id, String hotel_id, String room_id, String user_email, String start_date,
			String end_date, String rsv_date, String pay_yn) {
		this.rsv_id = rsv_id;
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.user_email = user_email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.rsv_date = rsv_date;
		this.pay_yn = pay_yn;
	}

	public ReserveVO(String rsv_id, String hotel_id, String room_id, String user_email, String start_date,
			String end_date, String pay_yn) {
		this.rsv_id = rsv_id;
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.user_email = user_email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.pay_yn = pay_yn;
	}

	public ReserveVO(String hotel_id, String room_id, String user_email, String start_date, String end_date,
			String pay_yn) {
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.user_email = user_email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.pay_yn = pay_yn;
	}

	public ReserveVO(String rsv_id, String hotel_id, String room_id, String user_email, String start_date,
			String end_date, String rsv_date, String pay_yn, String name, String admin_yn, String hotel_name,
			String addr_sd, String addr_sgg, String addr_emd, String total_room, String lon, String lat,
			String amenities, String grade, String hotel_img, String room_name, String adults, String price,
			String room_img, String room_num) {
		this.rsv_id = rsv_id;
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.user_email = user_email;
		this.start_date = start_date;
		this.end_date = end_date;
		this.rsv_date = rsv_date;
		this.pay_yn = pay_yn;
		this.name = name;
		this.admin_yn = admin_yn;
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
		this.room_name = room_name;
		this.adults = adults;
		this.price = price;
		this.room_img = room_img;
		this.room_num = room_num;
	}

	public String getRsv_id() {
		return rsv_id;
	}

	public void setRsv_id(String rsv_id) {
		this.rsv_id = rsv_id;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getRsv_date() {
		return rsv_date;
	}

	public void setRsv_date(String rsv_date) {
		this.rsv_date = rsv_date;
	}

	public String getPay_yn() {
		return pay_yn;
	}

	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
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

	public String getTotal_room() {
		return total_room;
	}

	public void setTotal_room(String total_room) {
		this.total_room = total_room;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
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

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getAdults() {
		return adults;
	}

	public void setAdults(String adults) {
		this.adults = adults;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRoom_img() {
		return room_img;
	}

	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}

	public String getRoom_num() {
		return room_num;
	}

	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	@Override
	public String toString() {
		return "ReserveVO [rsv_id=" + rsv_id + ", hotel_id=" + hotel_id + ", room_id=" + room_id + ", user_email="
				+ user_email + ", start_date=" + start_date + ", end_date=" + end_date + ", rsv_date=" + rsv_date
				+ ", pay_yn=" + pay_yn + ", name=" + name + ", admin_yn=" + admin_yn + ", hotel_name=" + hotel_name
				+ ", addr_sd=" + addr_sd + ", addr_sgg=" + addr_sgg + ", addr_emd=" + addr_emd + ", total_room="
				+ total_room + ", lon=" + lon + ", lat=" + lat + ", amenities=" + amenities + ", grade=" + grade
				+ ", hotel_img=" + hotel_img + ", room_name=" + room_name + ", adults=" + adults + ", price=" + price
				+ ", room_img=" + room_img + ", room_num=" + room_num + "]";
	}

}
