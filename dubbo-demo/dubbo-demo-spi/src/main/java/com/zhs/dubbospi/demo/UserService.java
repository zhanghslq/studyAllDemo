package com.zhs.dubbospi.demo;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface UserService {
	public void findById(int id);
}