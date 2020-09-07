package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.ReserveVO;

@Service("reserveBiz")
public class ReserveBiz implements Biz<String, ReserveVO> {

	@Resource(name = "reserveDao")
	Dao<String, ReserveVO> dao;

	@Override
	public void register(ReserveVO v) throws Exception {
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
	public void modify(ReserveVO v) throws Exception {
		int result = dao.update(v);
		if (result == 0) {
			throw new Exception();
		}
	}

	@Override
	public ReserveVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<ReserveVO> get() throws Exception {
		return dao.selectall();
	}


	@Override
	public ArrayList<ReserveVO> search(Object obj) throws Exception {
		return dao.search(obj);
	}

	@Override
	public void registerAdmin(ReserveVO v) throws Exception {
		dao.insertAdminForm(v);

	}

	@Override
	public String count() throws Exception {
		return dao.selectall_count();
	}

	@Override
	public ArrayList<ReserveVO> getN(String k) throws Exception {
		return dao.selectN(k);
	
	}


	@Override
	public void modifyAdmin(ReserveVO v) throws Exception {
		int result = dao.updateAdminForm(v);
		if (result == 0) {
			throw new Exception();
		}		
	}

}
