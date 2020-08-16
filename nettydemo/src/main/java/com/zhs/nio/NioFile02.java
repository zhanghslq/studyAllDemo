package com.zhs.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: zhs
 * @date: 2020/4/23 15:07
 */
public class NioFile02 {
    public static void main(String[] args) throws IOException {
        File file = new File("d://test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //读入buffer
        channel.read(byteBuffer);

        //读取
        System.out.println(new String(byteBuffer.array()));
    }
}
