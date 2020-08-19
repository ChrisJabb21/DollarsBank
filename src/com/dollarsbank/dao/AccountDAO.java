package com.dollarsbank.dao;

import java.util.ArrayList;

public interface AccountDAO<T> extends Operations<T>
{
	public T get(int userId);
	public ArrayList<T> getAll(int userId);
}
