package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.HotelList;
import com.vo.HotelRoomVO;
import com.vo.UserVO;

@Controller
public class AdminController {

	@Resource(name = "hotelListBiz")
	Biz<String, HotelList> hbiz;
	
	@Resource(name = "ubiz")
	Biz<String, UserVO> ubiz;
	
	@Resource(name = "hotelRoomBiz")
	Biz<String, HotelRoomVO> rbiz;	

	@RequestMapping("/admin.mc")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		
		String hotelTotal = null;
		String userTotal = null;
		try {
			hotelTotal = hbiz.count();
			userTotal = ubiz.count();
			System.out.println(hotelTotal);
			System.out.println(userTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelTotalNum", hotelTotal);
		mv.addObject("userTotalNum", userTotal);
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
//			for (HotelList hList : hotelList) {
//				System.out.println(hList);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("hotelList", hotelList);
		mv.addObject("centerpage", "adminHotelList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelRegister.mc")
	public ModelAndView adminHotelAdd() {
		ModelAndView mv = new ModelAndView();	
		mv.addObject("centerpage", "adminHotelRegister.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
	
	@RequestMapping("/adminHotelRegisterImpl.mc")
	public String adminHotelRegisterImpl(HotelList h) {
		ModelAndView mv = new ModelAndView();
		System.out.println(h);
		try {
			hbiz.registerAdmin(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:adminHotelList.mc";
	}
	
	@RequestMapping("/adminHotelRoomRegisterImpl.mc")
	public String adminHotelRoomRegisterImpl(HotelRoomVO hr) {
		ModelAndView mv = new ModelAndView();
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
	public String adminHotelModifyImpl(HotelList h) {
		System.out.println(h);
		String hotelid = h.getHotel_id();
		try {
			hbiz.modifyAdmin(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:hotelDetail.mc?id="+hotelid;
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
		
		mv.addObject("userList", ulist);
		mv.addObject("centerpage", "adminUserList.jsp");
		mv.setViewName("admin/index");
		return mv;
	}
}
