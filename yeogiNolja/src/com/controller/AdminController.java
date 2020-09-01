package com.controller;

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
	Biz<String, HotelList> biz;

	@RequestMapping("/admin.mc")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		
		String hotelTotal = null;
		try {
			hotelTotal = biz.count();
			System.out.println(hotelTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelTotalNum", hotelTotal);
		mv.addObject("centerpage", "admin_center.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
}
