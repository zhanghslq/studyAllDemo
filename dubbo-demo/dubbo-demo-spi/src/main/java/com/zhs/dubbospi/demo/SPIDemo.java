package com.zhs.dubbospi.demo;

import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.ServiceLoader;

public class SPIDemo {
	public static void main(String[] args) {
        ExtensionLoader<UserService> extensionLoader = ExtensionLoader.getExtensionLoader(UserService.class);
        
        //loader userServiceImpl1
        UserService userServiceImpl1 = extensionLoader.getExtension("userServiceImpl1");
        userServiceImpl1.findById(1);
        
        //loader userServiceImpl2
        UserService userServiceImpl2 = extensionLoader.getExtension("userServiceImpl2");
        userServiceImpl2.findById(2);

        /*ServiceLoader<UserService> load = ServiceLoader.load(UserService.class);
            for (UserService userService : load) {
                    userService.findById(1);
            }*/

    }
}
