package com.vo;

public class HotelRoomVO {
	String room_id;
	String room_name;
	String hotel_id;
	String hotel_name;
	int capacity;
	double price;
	String room_img;
	
	public HotelRoomVO() {
	}


	public HotelRoomVO(String room_id) {
		this.room_id = room_id;
	}


	public HotelRoomVO(String room_id, String room_name, String hotel_id, String hotel_name, int capacity, double price,
			String room_img) {
		this.room_id = room_id;
		this.room_name = room_name;
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.capacity = capacity;
		this.price = price;
		this.room_img = room_img;
	}


	public HotelRoomVO(String room_id, String room_name, String hotel_id, String hotel_name, int capacity, double price) {
		this.room_id = room_id;
		this.room_name = room_name;
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.capacity = capacity;
		this.price = price;
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


	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
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


	@Override
	public String toString() {
		return "RoomVO [room_id=" + room_id + ", room_name=" + room_name + ", hotel_id=" + hotel_id + ", hotel_name="
				+ hotel_name + ", capacity=" + capacity + ", price=" + price + ", room_img=" + room_img + "]";
	}
	
	
	
	
}