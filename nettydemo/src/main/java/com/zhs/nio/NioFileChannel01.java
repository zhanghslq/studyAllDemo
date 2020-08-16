package com.zhs.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: zhs
 * @date: 2020/4/23 14:37
 */
public class NioFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello,张海松";
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();

        //创建一个缓冲区buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将str放入buffer
        byteBuffer.put(str.getBytes());

        //对byteBuffer反转
        byteBuffer.flip();

        //将byteBuffer的数据写入channer

        channel.write(byteBuffer);

        channel.close();
        fileOutputStream.close();
    }
}
