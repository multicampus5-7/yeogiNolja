package com.dao;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.ReserveVO;

@Repository("reserveDao")
public interface ReserveDao extends Dao<String, ReserveVO> {

}
