package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.HotelList;

@Controller
public class HotelController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> biz;

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

	@RequestMapping("hotelList.mc")
	public ModelAndView hotelList(HttpServletRequest request) {

		String dest = request.getParameter("dest");

		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();

		try {
			hotelList = biz.search(dest);
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
