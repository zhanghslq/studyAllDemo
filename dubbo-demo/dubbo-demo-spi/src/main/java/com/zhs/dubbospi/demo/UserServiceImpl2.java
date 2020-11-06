package com.zhs.dubbospi.demo;

public class UserServiceImpl2 implements UserService{
	@Override
	public void findById(int id) {
    	System.out.println("UserServiceImpl2 find User " + id);
    }
}
