package com.zhs.netty.first;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: zhs
 * @date: 2020/10/3 12:03
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 连接被注册
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("httpserverCodec",new HttpServerCodec());

        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());

    }
}
