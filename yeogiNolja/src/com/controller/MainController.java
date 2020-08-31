package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "ubiz")
	Biz<String, UserVO> biz;

	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage", "center.jsp");
		mv.addObject("setBookingForm", true);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("hotelList.mc")
	public ModelAndView hotelList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage", "hotelList.jsp");
		mv.addObject("setBookingForm", true);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/index");
		return mv;
	}

	@RequestMapping("loginImpl.mc")
	public ModelAndView loginImpl(HttpServletRequest request) {
		System.out.println("zzzzzzzz");
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		UserVO user = null;
		try {
			user = biz.get(id);
			if (user.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				mv.addObject("centerpage", "login/loginok.jsp");
			} else {
				System.out.println("loginfail");
				mv.addObject("centerpage", "login/loginfail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("setBookingForm", true);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/logout.mc")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		return new ModelAndView("redirect: main.mc");
	}
}
