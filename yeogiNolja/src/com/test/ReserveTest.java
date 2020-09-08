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

		// select all reservations
//		ArrayList<ReserveVO> list = null;
//		try {
//			list = biz.getN("saebom023@gmail.com");
//
//			for (ReserveVO reserveVO : list) {
//				System.out.println(reserveVO);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			biz.remove("rv0032");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//select WHERE DATE
//		String start_date = "2020-09-06";
//		String end_date ="2020-09-20" ;
//		ReserveVO r = new ReserveVO(start_date, end_date);
//		System.out.println(r);
//		ArrayList<ReserveVO> list = null;
//		try {
//			list = biz.getByDate(r);
//			for (ReserveVO result : list) {
//				System.out.println(result);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		

//		//insert Hotel Reserve 
//		String hotel_id="ht1022";
//		String room_id="rm1001";
//		String user_email="ryan@gmail.com";
//		String start_date="2020-09-01";
//		String end_date="2020-09-20";
//		String pay_yn="Y";
//		
//		ReserveVO r = new ReserveVO(hotel_id, room_id, user_email, start_date, end_date, pay_yn);
//		System.out.println(r);
//		try {
//			biz.register(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		//select ALL JOIN (RSV + HOTEL + ROOM + USERS)
//		ReserveVO r = new ReserveVO();
//		String rsv_id="rv0001";
//		try {
//			r = biz.get(rsv_id);
//			System.out.println(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		factory.close();
		System.out.println("end");
	}
}
