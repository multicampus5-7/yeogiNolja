package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.HotelList;
import com.vo.UserVO;

@Controller
public class AdminController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> hbiz;
	
	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;

	@RequestMapping("/admin.mc")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		
		String hotelTotal = null;
		String userTotal = null;
		try {
			hotelTotal = hbiz.count();
			userTotal = ubiz.count();
			System.out.println(hotelTotal);
			System.out.println(userTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelTotalNum", hotelTotal);
		mv.addObject("userTotalNum", userTotal);
		mv.addObject("centerpage", "adminCenter.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelList.mc")
	public ModelAndView adminHotelList() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		try {
			hotelList = hbiz.get();
//			for (HotelList hList : hotelList) {
//				System.out.println(hList);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelList", hotelList);
		mv.addObject("centerpage", "adminHotelList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelRegister.mc")
	public ModelAndView adminHotelAdd() {
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("centerpage", "adminHotelRegister.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
}
