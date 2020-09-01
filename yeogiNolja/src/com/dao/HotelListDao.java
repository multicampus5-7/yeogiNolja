package com.dao;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.HotelList;

@Repository("hotelListDao")
public interface HotelListDao extends Dao<String, HotelList> {

}
