package com.dao;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.HotelRoomVO;

@Repository("hotelRoomDao")
public interface HotelRoomDao extends Dao<String, HotelRoomVO> {

}
