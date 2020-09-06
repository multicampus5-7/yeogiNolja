package com.vo;

public class ReserveVO {
	private String rsv_id;
	private String hotel_id;
	private String room_id;
	private String user_email;
	private String start_date;
	private String end_date;
	private String rsv_date;
	private String pay_yn;

	public ReserveVO() {
	}
	
	public ReserveVO(String rsv_id) {
		this.rsv_id = rsv_id;
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

	@Override
	public String toString() {
		return "ReserveVO [rsv_id=" + rsv_id + ", hotel_id=" + hotel_id + ", room_id=" + room_id + ", user_email="
				+ user_email + ", start_date=" + start_date + ", end_date=" + end_date + ", rsv_date=" + rsv_date
				+ ", pay_yn=" + pay_yn + "]";
	}

}
