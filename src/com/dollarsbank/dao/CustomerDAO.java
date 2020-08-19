package com.dollarsbank.dao;

public interface CustomerDAO<T> extends Operations<T>
{
		public T get(String userName);
		public T get(char[] mobile);
	
}
