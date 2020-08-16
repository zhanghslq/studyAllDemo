package com.zhs.nio;

import jdk.management.resource.internal.TotalResourceContext;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author: zhs
 * @date: 2020/4/23 14:05
 */
public class BasicBuffer {
    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
