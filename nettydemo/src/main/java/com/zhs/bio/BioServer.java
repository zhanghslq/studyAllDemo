package com.zhs.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhs
 * @date: 2020/4/23 13:31
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        // cmd 窗口 telnet 127.0.0.1 6666 可以链接   ctrl + 】  可以输入  send  ..可以发送
        System.out.println("服务器启动");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("接收到一个客户端");
            executorService.execute(new Runnable() {
                public void run() {
                    //和客户端通讯
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {

        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据
            while (true) {
                System.out.println("线程" + Thread.currentThread().getId() + "=======" + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的链接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
