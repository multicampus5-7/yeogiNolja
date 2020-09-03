package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.HotelList;

@Service("hotelListBiz")
public class HotelListBiz implements Biz<String, HotelList> {

	@Resource(name = "hotelListDao")
	Dao<String, HotelList> dao;

	@Override
	public void register(HotelList v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		int result = dao.delete(k);
		if (result == 0) {
			throw new Exception();
		}
	}

	@Override
	public void modify(HotelList v) throws Exception {
		int result = dao.update(v);
		if (result == 0) {
			throw new Exception();
		}
	}

	@Override
	public HotelList get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<HotelList> get() throws Exception {
		return dao.selectall();
	}

	public ArrayList<HotelList> findByKey(String k) throws Exception {
		return null;
	}

	@Override
	public ArrayList<HotelList> search(Object obj) throws Exception {
		return dao.search(obj);
	}

	@Override
	public void registerAdmin(HotelList v) throws Exception {
		dao.insertAdminFrom(v);

	}

	@Override
	public String count() throws Exception {
		return dao.selectall_count();
	}

	@Override
	public ArrayList<HotelList> getN(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
