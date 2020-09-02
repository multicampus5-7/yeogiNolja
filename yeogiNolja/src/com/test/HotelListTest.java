package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.HotelList;

public class HotelListTest {
	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC

		Biz<String, HotelList> biz = (Biz) factory.getBean("hotelListBiz");

//		try {
//			biz.remove("test");
//			System.out.println("ok");
//		} catch (Exception e) {
//			System.out.println("fail");
//			e.printStackTrace();
//		}

//		try {
//			HotelList h = biz.get("ht0001");
//			System.out.println("----------" + h);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//Count Total Hotel
		String hotelTotal = null;
		try {
			hotelTotal = biz.count();
			System.out.println(hotelTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	

//		ArrayList<HotelList> list = null;
//		try {
//			list = biz.get();
//			for (HotelList hotelList : list) {
//				System.out.println(hotelList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		//Insert Hotel Info
//		String hotel_id = "ht01";
//		String hotel_name = "ase";
//		String addr_sd = "SD";
//		String addr_sgg = "SGG";
//		String addr_emd = "EMD";
//		int total_room = 50;
//		String amenities = "AMAMAM MAM";
//		String grade = "5-stars";
//		HotelList h = new HotelList(hotel_id, hotel_name, addr_sd, addr_sgg, 
//				addr_emd, total_room, amenities, grade);
//		try {
//			biz.registerAdmin(h);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		factory.close();
		System.out.println("end");
	}
}
