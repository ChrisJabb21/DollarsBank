package com.dollarsbank.dao;

import java.util.ArrayList;

public interface Operations<T> {
	public T get(int id);
	public ArrayList<T> getAll();
	public void create(T t);
	public void update(T t);

}
