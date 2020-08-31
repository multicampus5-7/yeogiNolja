package com.vo;

public class HotelList {
	String hotelId;
	String name;
	String addrSd;
	String addrSgg;
	String addrEmp;
	int totalRoom;
	double lon;
	double lat;
	String amenities;
	String grade;
	String hotelImg;

	public HotelList() {
	}

	public HotelList(String hotelId, String name, String addrSd, String addrSgg, String addrEmp, int totalRoom,
			double lon, double lat, String amenities, String grade, String hotelImg) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.addrSd = addrSd;
		this.addrSgg = addrSgg;
		this.addrEmp = addrEmp;
		this.totalRoom = totalRoom;
		this.lon = lon;
		this.lat = lat;
		this.amenities = amenities;
		this.grade = grade;
		this.hotelImg = hotelImg;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrSd() {
		return addrSd;
	}

	public void setAddrSd(String addrSd) {
		this.addrSd = addrSd;
	}

	public String getAddrSgg() {
		return addrSgg;
	}

	public void setAddrSgg(String addrSgg) {
		this.addrSgg = addrSgg;
	}

	public String getAddrEmp() {
		return addrEmp;
	}

	public void setAddrEmp(String addrEmp) {
		this.addrEmp = addrEmp;
	}

	public int getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
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

	public String getHotelImg() {
		return hotelImg;
	}

	public void setHotelImg(String hotelImg) {
		this.hotelImg = hotelImg;
	}

	@Override
	public String toString() {
		return "HotelList [hotelId=" + hotelId + ", name=" + name + ", addrSd=" + addrSd + ", addrSgg=" + addrSgg
				+ ", addrEmp=" + addrEmp + ", totalRoom=" + totalRoom + ", lon=" + lon + ", lat=" + lat + ", amenities="
				+ amenities + ", grade=" + grade + ", hotelImg=" + hotelImg + "]";
	}
	
	
}
