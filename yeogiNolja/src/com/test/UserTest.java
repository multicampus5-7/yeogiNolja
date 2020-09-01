package com.test;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.UserVO;

public class UserTest {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC

		Biz<String, UserVO> biz = (Biz) factory.getBean("ubiz");

//		UserVO u = 
//		new UserVO("id73", "pwd73","testName");
//		try {
//			biz.register(u);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		UserVO u = new UserVO("id73", "pwd73333", "testName");
//		try {
//			biz.register(u);
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			biz.remove("id73");
//			System.out.println("OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		UserVO content = null;
//		try {
//			content = biz.get("saebom023@gmail.com");
//			System.out.println(content);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
		ArrayList<UserVO> list = null;
		try {
			list = biz.get();
			for (UserVO co : list) {
				System.out.println(co);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
