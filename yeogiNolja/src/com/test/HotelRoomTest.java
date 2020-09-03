package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.HotelRoomVO;

public class HotelRoomTest {
	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC

		Biz<String, HotelRoomVO> biz = (Biz) factory.getBean("hotelRoomBiz");	

//		//select all room
//		ArrayList<HotelRoomVO> list = null;
//		try {
//			list = biz.get();
//			for (HotelRoomVO hotelRoomList : list) {
//				System.out.println(hotelRoomList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		factory.close();
//		System.out.println("end");
		
		
//		//select Hotels Room
//		ArrayList<HotelRoomVO> list = null;
//		try {
//			list = biz.getN("ht0001");
//			for (HotelRoomVO hotelRoomList : list) {
//				System.out.println(hotelRoomList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//insert Hotel Room 
		String room_id = "rm101";
		String room_name ="aaa";
		String hotel_id="ht111";
		int adults = 5;
		double price = 300000;
		String room_img = "aa.jpg";
		String room_num = "1515";
		
		HotelRoomVO hr = new HotelRoomVO(room_id, room_name, hotel_id, adults, price, room_num);
		System.out.println(hr);
		try {
			biz.registerAdmin(hr);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		
		factory.close();
		System.out.println("end");		
	}
}
