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
public class UserController {

	@Resource(name = "ubiz")
	Biz<String, UserVO> biz;

	@RequestMapping("login.mc")
	public String login() {
		return "user/login";
	}

	@RequestMapping("loginImpl.mc")
	public ModelAndView loginImpl(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		UserVO user = null;
		try {
			user = biz.get(id);
			if (user.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				mv.addObject("centerpage", "user/loginok.jsp");
			} else
				mv.addObject("centerpage", "user/loginfail.jsp");

		} catch (Exception e) {
			mv.addObject("centerpage", "user/loginfail.jsp");
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/logout.mc")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		return new ModelAndView("redirect: main.mc");
	}
	/*회원가입 관련*/
	@RequestMapping("useradd.mc")
	public String useradd() {
		return "user/register";
	}
	@RequestMapping("useraddimpl.mc")
	public ModelAndView useraddimpl(ModelAndView mv, UserVO user) {
		try {
			biz.register(user);
		} catch (Exception e) {
			mv.addObject("centerpage", "user/registerfail.jsp");
			e.printStackTrace();
		}
		mv.addObject("centerpage", "user/registerok.jsp");
		mv.setViewName("main");
		return mv;
	}
	/*login 된 회원의 정보 수정하기 관련*/	
	@RequestMapping("userdetail.mc")
	public ModelAndView userdetail(ModelAndView mv, String email) {
		System.out.println("R U WORKING");
		UserVO user = null;
		try {
			user=biz.get(email);
			System.out.println(user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("userdetail", user);
		mv.addObject("centerpage", "registerok.jsp");
		mv.setViewName("main");
		return mv;
	}

	
	
}
