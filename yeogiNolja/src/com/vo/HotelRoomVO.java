package com.vo;

public class HotelRoomVO {
	String room_id;
	String room_name;
	String hotel_id;
	int adults;
	double price;
	String room_img;
	String room_num;
	
	public HotelRoomVO() {
	}


	public HotelRoomVO(String room_id) {
		this.room_id = room_id;
	}


	public HotelRoomVO(String room_id, String room_name, String hotel_id, int adults, double price,
			String room_num) {
		this.room_id = room_id;
		this.room_name = room_name;
		this.hotel_id = hotel_id;
		this.adults = adults;
		this.price = price;
		this.room_num = room_num;
	}


	public HotelRoomVO(String room_id, String room_name, String hotel_id, int adults, double price,
			String room_img, String room_num) {
		this.room_id = room_id;
		this.room_name = room_name;
		this.hotel_id = hotel_id;
		this.adults = adults;
		this.price = price;
		this.room_img = room_img;
		this.room_num = room_num;
	}


	public String getRoom_id() {
		return room_id;
	}


	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}


	public String getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}


	public int getadults() {
		return adults;
	}


	public void setadults(int adults) {
		this.adults = adults;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
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
		return "HotelRoomVO [room_id=" + room_id + ", room_name=" + room_name + ", hotel_id=" + hotel_id
				+ ", adults=" + adults + ", price=" + price + ", room_img="
				+ room_img + ", room_num=" + room_num + "]";
	}


	
	
	
}