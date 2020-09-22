package com.zhs.client;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DemoNettyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 服务端发过来消息时调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到来自服务端的一条消息");
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        System.out.println(new String(result1));
        //result.release();
        //关闭连接
//        ctx.close();
    }

    /**
     * 异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 连接到服务器调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String msg = Meesage.CLIENT_MESSAGE;
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.writeAndFlush(encoded);
    }

}
