package com.zhs.nio;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author: zhs
 * @date: 2020/8/16 12:44
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        //等客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;

        while (true) {
            int byteRead = 0 ;
            while (byteRead<messageLength){
                long l = socketChannel.read(byteBuffers);
                byteRead+=l;
                System.out.println("byteRead="+byteRead);
                // 使用流打印，看看当前的buffer的position和limit

            }
            Arrays.asList(byteBuffers).stream()
                    .map(buffer -> "position0"+buffer.position()+"limmit="+buffer.limit()).forEach(System.out::println);

            Arrays.asList(byteBuffers).forEach(Buffer::flip);


            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite<messageLength){
                long l = socketChannel.write(byteBuffers);
                byteWrite+=l;
            }

            // 将所有buffer进行clear
            Arrays.asList(byteBuffers).forEach(ByteBuffer::clear);

            System.out.println("byteRead:="+byteRead+" byteWrite="+byteWrite+"messageLength="+messageLength);
        }


    }
}
