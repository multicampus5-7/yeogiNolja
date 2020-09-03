package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("centerpage", "center.jsp");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("bookingImpl.mc")
	public String bookingImpl(HttpServletRequest request, Booking booking) {
		String dest = "";
		try {
			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			session.setAttribute("booking", booking);
			dest = URLEncoder.encode(booking.getDest(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("booking error");
			e.printStackTrace();
		}

		return "redirect: hotelList.mc?dest=" + dest;
	}

}
