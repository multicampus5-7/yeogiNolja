package com.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
//			for (ReserveVO r : list) {
//				System.out.println(r);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
				
		
//		//insert Hotel Reserve 
//		String rsv_id="rv1001";
//		String hotel_id="ht1001";
//		String room_id="rm1001";
//		String user_email="ryan@gmail.com";
//		String start_date="2020-09-01";
//		String end_date="2020-09-20";
//		String pay_yn="Y";
//		
//		ReserveVO r = new ReserveVO(rsv_id, hotel_id, room_id, user_email, start_date, end_date, pay_yn);
//		System.out.println(r);
//		try {
//			biz.registerAdmin(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//select Hotels Room
		SimpleDateFormat dateFrom = new SimpleDateFormat ( "yyyy-MM-dd");
		String d = dateFrom.format(new java.util.Date());
		ArrayList<ReserveVO> list = null;
		
		try {
			list = biz.getN(d);
			for (ReserveVO r : list) {
				System.out.println(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		factory.close();
		System.out.println("end");		
	}
}
