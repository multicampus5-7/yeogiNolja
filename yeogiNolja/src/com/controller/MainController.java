package com.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Booking;
import com.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "ubiz")
	Biz<String, UserVO> biz;
	Booking booking;

	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		String centerPage = request.getParameter("page");
		if (centerPage == null)
			centerPage = "center.jsp";
		System.out.println("center: " + centerPage);
		mv.addObject("centerpage", centerPage);
		mv.addObject("booking", booking);
		mv.addObject("setBooking", true);

		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("bookingImpl.mc")
	public String bookingImpl(HttpServletRequest request, Booking booking) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("booking error");
			e.printStackTrace();
		}
		this.booking = booking;
		return "redirect: hotelList.mc";
	}

	@RequestMapping("hotelList.mc")
	public ModelAndView hotelList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("centerpage", "hotelList.jsp");
		mv.addObject("setBooking", true);
		mv.addObject("booking", booking);
		mv.setViewName("main");
		return mv;
	}
}
