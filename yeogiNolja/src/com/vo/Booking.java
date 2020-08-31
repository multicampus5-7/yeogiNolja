package com.vo;

public class Booking {
	private String dest;
	private String inDate;
	private String outDate;
	private String hotelType;
	private String roomNum;
	private String adult;

	public Booking() {
	}

	public Booking(String dest, String inDate, String outDate, String hotelType, String roomNum, String adult) {
		this.dest = dest;
		this.inDate = inDate;
		this.outDate = outDate;
		this.hotelType = hotelType;
		this.roomNum = roomNum;
		this.adult = adult;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	@Override
	public String toString() {
		return "Booking [dest=" + dest + ", inDate=" + inDate + ", outDate=" + outDate + ", hotelType=" + hotelType
				+ ", roomNum=" + roomNum + ", adult=" + adult + "]";
	}

}
