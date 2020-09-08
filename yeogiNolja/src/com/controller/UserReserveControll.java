package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.ReserveVO;
import com.vo.UserVO;

@Controller
public class UserReserveControll {
	@Resource(name = "reserveBiz")
	Biz<String, ReserveVO> rbiz;

	@RequestMapping("myReserve.mc")
	public ModelAndView myReserve(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		String email = user.getEmail();

		String st = request.getParameter("remove");
		if (st == null)
			st = "empty";
		ArrayList<ReserveVO> rlist = null;

		try {
			rlist = rbiz.getN(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("rList", rlist);
		mv.addObject("rListLen", rlist.size());
		mv.setViewName("user/myReserve");
		return mv;
	}

	@RequestMapping("removeReservation.mc")
	public ModelAndView removeReservation(String rsv_id) {
		ModelAndView mv = new ModelAndView("redirect: myReserve.mc");

		try {
			rbiz.remove(rsv_id);
			mv.addObject("remove", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("remove", "fail");
		}
		return mv;
	}
}
