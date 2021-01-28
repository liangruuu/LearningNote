package com.atguigu.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    //当通道就绪就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, server: (>^ω^<)喵", CharsetUtil.UTF_8));
    }



    //当通道有读取事件时（收到来自服务端的数据），会触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器回复的消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器的地址： " + ctx.channel().remoteAddress());

        /**
         * 如果加上这句 ctx.close(); 或者 ctx.channel().close();
         * NettyClient文件就会继续执行接下去的以及finally代码块里的代码
         *         {
         *             System.out.println("阻塞后的实现......");
         *         } finally{
         *             System.out.println("我进来了......");
         *             group.shutdownGracefully();
         *
         *         }
         * 因为这行代码的意思是关闭客户端的channel，而如果channel被关闭
         * channelFuture.channel().closeFuture().sync();就会取消阻塞随即执行接下来的代码
         */
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
