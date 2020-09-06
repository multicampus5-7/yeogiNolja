package com.test;

import java.util.ArrayList;
import java.sql.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ReserveVO;

public class ReserveTest {
	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC

		Biz<String, ReserveVO> biz = (Biz) factory.getBean("reserveBiz");	

//		//select all reservations
//		ArrayList<ReserveVO> list = null;
//		try {
//			list = biz.get();
//			for (ReserveVO hotelRoomList : list) {
//				System.out.println(hotelRoomList);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
				
		
		//insert Hotel Reserve 
		String rsv_id="rv1001";
		String hotel_id="ht1001";
		String room_id="rm1001";
		String user_email="ryan@gmail.com";
		String start_date="2020-09-01";
		String end_date="2020-09-20";
		String rsv_date="2020-09-20";
		String pay_yn="Y";
		
		ReserveVO r = new ReserveVO(rsv_id, hotel_id, room_id, user_email, start_date, end_date, rsv_date, pay_yn);
		System.out.println(r);
		try {
			biz.registerAdmin(r);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		factory.close();
		System.out.println("end");		
	}
}
