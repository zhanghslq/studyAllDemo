package com.zhs.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: zhs
 * @date: 2020/4/23 14:37
 */
public class NioFileChannel03 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("d://test.txt");
        FileChannel channel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("d://2.txt");
        FileChannel channel1 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            byteBuffer.clear();
            int read = channel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            channel1.write(byteBuffer);
        }

    }
}
