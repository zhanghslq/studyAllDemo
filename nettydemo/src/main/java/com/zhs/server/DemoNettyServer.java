package com.zhs.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DemoNettyServer {

    public void bind(int port) throws Exception {
        
        // 主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 从线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // netty服务器启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //绑定两个线程组
            serverBootstrap.group(bossGroup, workerGroup)
                    // 用于构造socketchannel工厂
                    .channel(NioServerSocketChannel.class)
                    //指定NIO的模式
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 子处理器，用于处理workerGroup
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DemoNettyServerHandler());
                        }
                    });

            // 启动server，绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

            System.out.println("server start");
            // 监听关闭的channel，等待服务器 socket 关闭 。设置位同步方式
            channelFuture.channel().closeFuture().sync();
            System.out.println("server close");
        } finally {
            //退出线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8888;
        new DemoNettyServer().bind(port);
    }

}