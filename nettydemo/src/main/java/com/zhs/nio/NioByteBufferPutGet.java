package com.zhs.nio;

import java.nio.ByteBuffer;

/**
 * @author: zhs
 * @date: 2020/4/23 15:24
 */
public class NioByteBufferPutGet {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(100);
        byteBuffer.putChar('s');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getChar());

    }
}
