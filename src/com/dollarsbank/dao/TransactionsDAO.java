package com.dollarsbank.dao;

import java.util.ArrayList;

public interface TransactionsDAO<T> extends Operations<T> {
	public T get (int id);
	public ArrayList<T> getAll(int userId);
}
