package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.HotelList;

@Controller
public class HotelController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> biz;

	@RequestMapping("hotelList.mc")
	public ModelAndView hotelList() {
		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		try {
			hotelList = biz.get();
			for (HotelList hotelList2 : hotelList) {
				System.out.println(hotelList2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelList", hotelList);
		mv.addObject("centerpage", "hotel/hotelList.jsp");
		mv.setViewName("main");
		return mv;
	}
}
