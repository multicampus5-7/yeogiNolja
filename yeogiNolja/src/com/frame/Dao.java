package com.frame;

import java.util.ArrayList;

import com.vo.HotelList;

public interface Dao<K,V> {
	public int insert(V v) throws Exception;
	public int delete(K k) throws Exception;
	public int update(V v) throws Exception;
	public V select(K k) throws Exception;
	public ArrayList<V> selectall() throws Exception;
	public ArrayList<V> search(Object obj) throws Exception;
	
	public K selectall_count() throws Exception;
	public void insertAdminForm(V v) throws Exception;
	public int updateAdminForm(V v) throws Exception;
	public ArrayList<V> selectN(K k) throws Exception;

	public void insertAdminFrom(V v);
}
