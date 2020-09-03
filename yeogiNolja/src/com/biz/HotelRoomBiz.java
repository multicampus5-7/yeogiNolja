package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.HotelRoomVO;

@Service("hotelRoomBiz")
public class HotelRoomBiz implements Biz<String, HotelRoomVO> {

	@Resource(name = "hotelRoomDao")
	Dao<String, HotelRoomVO> dao;

	@Override
	public void register(HotelRoomVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void registerAdmin(HotelRoomVO v) throws Exception {
		dao.insertAdminForm(v);
	}

	@Override
	public void remove(String k) throws Exception {
		int result = dao.delete(k);
		if (result == 0) {
			throw new Exception();
		}
	}

	@Override
	public void modify(HotelRoomVO v) throws Exception {
		int result = dao.update(v);
		if (result == 0) {
			throw new Exception();
		}
	}

	@Override
	public HotelRoomVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<HotelRoomVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public ArrayList<HotelRoomVO> search(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String count() throws Exception {
		return dao.selectall_count();
	}

	@Override
	public ArrayList<HotelRoomVO> getN(String k) throws Exception {
		return dao.selectN(k);
	}

	@Override
	public void modifyAdmin(HotelRoomVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
