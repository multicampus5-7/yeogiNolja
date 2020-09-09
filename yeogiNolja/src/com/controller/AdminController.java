package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.HotelList;
import com.vo.HotelRoomVO;
import com.vo.ReserveVO;
import com.vo.UserVO;

@Controller
public class AdminController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> hbiz;
	
	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;
	
	@Resource(name = "hotelRoomBiz")
	Biz<String, HotelRoomVO> rbiz;	

	@Resource(name = "reserveBiz")
	Biz<String, ReserveVO> rsvbiz;	
	
	@RequestMapping("/admin.mc")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		
		String hotelTotal = null;
		String userTotal = null;
		String todayRsvTotal = null;

		try {
			hotelTotal = hbiz.count();
			userTotal = ubiz.count();
			todayRsvTotal = rsvbiz.count();
			System.out.println(hotelTotal);
			System.out.println(userTotal);
			System.out.println(todayRsvTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelTotalNum", hotelTotal);
		mv.addObject("userTotalNum", userTotal);
		mv.addObject("rsvTotalNum", todayRsvTotal);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("message", "messageNull.jsp");		
		mv.addObject("hotelList", hotelList);
		mv.addObject("centerpage", "adminHotelList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelRegister.mc")
	public ModelAndView adminHotelAdd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "messageNull.jsp");
		mv.addObject("centerpage", "adminHotelRegister.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelRegisterImpl.mc")
	public ModelAndView adminHotelRegisterImpl(HotelList h) {
		ModelAndView mv = new ModelAndView();
		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		System.out.println(h);
		try {
			hbiz.registerAdmin(h);
			hotelList = hbiz.get();
			mv.addObject("message", "messageOk.jsp");
			mv.addObject("hotelList", hotelList);
			mv.addObject("centerpage", "adminHotelList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("message", "messageFail.jsp");
			mv.addObject("centerpage", "adminHotelRegister.jsp");	
		}
		mv.setViewName("admin/index");	
		return mv;
	}
	
	@RequestMapping("/adminHotelRoomRegisterImpl.mc")
	public String adminHotelRoomRegisterImpl(HotelRoomVO hr) {
		System.out.println(hr);
		String hotelid = hr.getHotel_id();
		try {
			rbiz.registerAdmin(hr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:hotelDetail.mc?id="+hotelid;
	}
	
	@RequestMapping("hotelDetail.mc")
	public ModelAndView hotelDetail(String id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		HotelList h = null;
		ArrayList<HotelRoomVO> roomlist = new ArrayList<HotelRoomVO>();

		try {
			h = hbiz.get(id);
			roomlist = rbiz.getN(id);
			System.out.println(h);
			System.out.println(roomlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("message", "messageNull.jsp");
		mv.addObject("hotelDetail", h);
		mv.addObject("roomList", roomlist);
		mv.addObject("centerpage", "adminHotelDetail.jsp");
		mv.setViewName("admin/index");		
		return mv;
	}
	
	@RequestMapping("adminHotelModify.mc")
	public ModelAndView adminHotelModify(String id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		HotelList h = null;
		ArrayList<HotelRoomVO> roomlist = new ArrayList<HotelRoomVO>();

		try {
			h = hbiz.get(id);
			roomlist = rbiz.getN(id);
			System.out.println(h);
			System.out.println(roomlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelDetail", h);
		mv.addObject("centerpage", "adminHotelModify.jsp");
		mv.setViewName("admin/index");		
		return mv;
	}
	
	@RequestMapping("/adminHotelModifyImpl.mc")
	public ModelAndView adminHotelModifyImpl(HotelList h) {
		ModelAndView mv = new ModelAndView();
		HotelList hList = null;
		ArrayList<HotelRoomVO> roomlist = new ArrayList<HotelRoomVO>();
		System.out.println(h);
		String hotelid = h.getHotel_id();
		try {
			hbiz.modifyAdmin(h);
			hList = hbiz.get(hotelid);
			roomlist = rbiz.getN(hotelid);
			mv.addObject("message", "messageOk.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("message", "messageFail.jsp");
		}
		mv.addObject("hotelDetail", hList);
		mv.addObject("roomList", roomlist);
		mv.addObject("centerpage", "adminHotelDetail.jsp");
		mv.setViewName("admin/index");	
		return mv;
	}
	
	@RequestMapping("/adminUserList.mc")
	public ModelAndView adminUserList() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<UserVO> ulist = null;
		try {
			ulist = ubiz.get();
			for (UserVO co : ulist) {
				System.out.println(co);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("message", "messageNull.jsp");
		mv.addObject("userList", ulist);
		mv.addObject("centerpage", "adminUserList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminReserve.mc")
	public ModelAndView adminReserve() {
		ModelAndView mv = new ModelAndView();
		//select all reservations
		ArrayList<ReserveVO> rsvlist = null;
		try {
			rsvlist = rsvbiz.get();
			for (ReserveVO r : rsvlist) {
				System.out.println(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("reserveList", rsvlist);
		mv.addObject("centerpage", "adminReserveList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminRsvSearchDateImpl.mc")
	public ModelAndView adminRsvSearchDateImpl(ReserveVO rsv) {
		ModelAndView mv = new ModelAndView();
		System.out.println(rsv);
		
		ArrayList<ReserveVO> list = null;
		try {
			list = rsvbiz.getByDate(rsv);
			for (ReserveVO result : list) {
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		mv.addObject("requestInfo",rsv);
		mv.addObject("reserveList", list);
		mv.addObject("centerpage", "adminReserveList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("adminRsvDetail.mc")
	public ModelAndView adminRsvDetail(String id) {
		ModelAndView mv = new ModelAndView();
		ReserveVO r = new ReserveVO();
		System.out.println(id);
		try {
			r = rsvbiz.get(id);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("rsv", r);
		mv.addObject("message", "messageNull.jsp");
		mv.addObject("centerpage", "adminRsvDetail.jsp");
		mv.setViewName("admin/index");		
		return mv;
	}
	
	@RequestMapping("adminRsvModify.mc")
	public ModelAndView adminRsvModify(String id) {
		ModelAndView mv = new ModelAndView();
		ReserveVO r = new ReserveVO();
		System.out.println(id);
		try {
			r = rsvbiz.get(id);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("rsv", r);
		mv.addObject("centerpage", "adminRsvModify.jsp");
		mv.setViewName("admin/index");		
		return mv;
	}
	
	@RequestMapping("/adminRsvModifyImpl.mc")
	public ModelAndView adminRsvModifyImpl(ReserveVO rsv) {
		ModelAndView mv = new ModelAndView();
		ReserveVO r = new ReserveVO();
		System.out.println(rsv);
		try {
			rsvbiz.modify(rsv);
			r = rsvbiz.get(rsv.getRsv_id());
			mv.addObject("rsv", r);
			mv.addObject("message", "messageOk.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("message", "messageFail.jsp");
		}
		mv.addObject("centerpage", "adminRsvDetail.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminAutoCom.mc")
	@ResponseBody
	public void adminAutoCom(HttpServletResponse response) throws IOException {
		ArrayList<HotelList> hotelList = new ArrayList<HotelList>();
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
		JSONObject job = new JSONObject();
		try {
			hotelList = hbiz.get();
			userList = ubiz.get();
			
			JSONArray jarr1 = new JSONArray();
			JSONArray jarr2 = new JSONArray();
			HashSet<String> addrArr = new HashSet<String>();

			for (HotelList hotelList2 : hotelList) {
				jarr1.add(hotelList2.getName());
				//addrArr.add(hotelList2.getAddr_sgg());
			}
			
			for (UserVO u : userList) {
				jarr2.add(u.getName());
			}

			for (String string : addrArr) {
				//jarr.add(string);
			}
			job.put("data", jarr1);
			job.put("dataUser", jarr2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.close();
	}
	
	@RequestMapping("adminUserModify.mc")
	public ModelAndView adminUserModify(String id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		UserVO u = null;

		try {
			u = ubiz.get(id);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("userDetail", u);
		mv.addObject("centerpage", "adminUserModify.jsp");
		mv.setViewName("admin/index");		
		return mv;
	}
	
	@RequestMapping("/adminUserModifyImpl.mc")
	public ModelAndView adminUserModifyImpl(UserVO u) {
		ModelAndView mv = new ModelAndView();
		System.out.println(u);
		ArrayList<UserVO> ulist = null;	
		
		try {
			ubiz.modifyAdmin(u);
			ulist = ubiz.get();
			mv.addObject("userList", ulist);
			mv.addObject("message", "messageOk.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("message", "messageFail.jsp");
		}
		
		mv.addObject("centerpage", "adminUserList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
}
