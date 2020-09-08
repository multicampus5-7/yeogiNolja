package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Booking;
import com.vo.HotelList;
import com.vo.HotelRoomVO;
import com.vo.ReserveVO;

@Controller
public class HotelController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> biz;

	@Resource(name = "hotelRoomBiz")
	Biz<String, HotelRoomVO> hbiz;

	@Resource(name = "reserveBiz")
	Biz<String, ReserveVO> rbiz;

	@RequestMapping("/hotelListAutoCom.mc")
	@ResponseBody
	public void hotelListAutoCom(HttpServletResponse response) throws IOException {
		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		JSONObject job = new JSONObject();
		try {
			hotelList = biz.get();

			JSONArray jarr = new JSONArray();
			HashSet<String> addrArr = new HashSet<String>();

			for (HotelList hotelList2 : hotelList) {
				jarr.add(hotelList2.getName());
				addrArr.add(hotelList2.getAddr_sgg());
			}

			for (String string : addrArr) {
				jarr.add(string);
			}
			job.put("data", jarr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.close();
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

		return "redirect: hotelList.mc?";
	}

	@RequestMapping("hotelList.mc")
	public ModelAndView hotelList(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Booking booking = (Booking) session.getAttribute("booking");
		String orderBy;

		orderBy = request.getParameter("orderBy");
		if (orderBy == null) {
			orderBy = (String) session.getAttribute("orderBy");
			if (orderBy == null)
				orderBy = "hotel_id";
		} else {
			session.setAttribute("orderBy", orderBy);
		}
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";

		int stNum = Integer.parseInt(pageNum);
		stNum = (stNum - 1) * 5;
		int endNum = stNum + 4;

		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("dest", booking.getDest());
			map.put("orderBy", orderBy);

			hotelList = biz.search(map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelList", hotelList);
		mv.addObject("stNum", stNum);
		mv.addObject("endNum", endNum);
		mv.addObject("centerpage", "hotel/hotelList.jsp");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("hotelListDetail.mc")
	public ModelAndView hotelListDetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HotelList h = null;
		ArrayList<HotelRoomVO> hotelRoomList = null;
		String hotelId = request.getParameter("hotelId");
		try {
			h = biz.get(hotelId);
			hotelRoomList = hbiz.getN(hotelId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("hotel", h);
		mv.addObject("hotelRoomList", hotelRoomList);
		mv.addObject("centerpage", "hotel/hotelDetail.jsp");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("goReservePage.mc")
	public ModelAndView goReservePage(HttpServletRequest request) {
		String hotelId = request.getParameter("hotelId");
		String roomId = request.getParameter("roomId");

		HotelList hotel = null;
		HotelRoomVO hotelRoom = null;

		try {
			hotel = biz.get(hotelId);
			hotelRoom = hbiz.get(roomId);
			System.out.println(hotel);
			System.out.println(hotelRoom);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("hotel", hotel);
		session.setAttribute("room", hotelRoom);

		System.out.println(hotelId + roomId);
		if (session.getAttribute("user") == null)
			return new ModelAndView("redirect: login.mc");
		else
			return new ModelAndView("redirect: setReservePage.mc");
	}

	@RequestMapping("setReservePage.mc")
	public ModelAndView setReservePage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hotel/hotelReserve");
		return mv;

	}

	@RequestMapping("reserveImpl.mc")
	public ModelAndView reserveImpl(HttpServletRequest request, ReserveVO r) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		session.removeAttribute("booking");
		try {
			rbiz.register(r);
			mv.addObject("centerpage", "hotel/reserveOk.jsp");
		} catch (Exception e) {
			mv.addObject("centerpage", "hotel/reserveFail.jsp");
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
}
