package com.zhs.dubbospi.demo;

public class UserServiceImpl1 implements UserService{
	@Override
	public void findById(int id) {
    	System.out.println("UserServiceImpl1 find User " + id);
    }
}
