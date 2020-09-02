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
		
		
		//select Hotels Room
		ArrayList<HotelRoomVO> list = null;
		try {
			list = biz.getN("ht0001");
			for (HotelRoomVO hotelRoomList : list) {
				System.out.println(hotelRoomList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		factory.close();
		System.out.println("end");		
		
	}
}
