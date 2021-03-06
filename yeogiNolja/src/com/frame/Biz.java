package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz<K,V> {
	@Transactional
	public void register(V v) throws Exception;
	public void registerAdmin(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	public void modifyAdmin(V v) throws Exception;
	public V get(K k) throws Exception;
	public ArrayList<V> get() throws Exception;
	public ArrayList<V> search(Object obj) throws Exception;
	public K count() throws Exception;
	public ArrayList<V> getN(K k) throws Exception;
	public ArrayList<V> getByDate(V v) throws Exception;

}

