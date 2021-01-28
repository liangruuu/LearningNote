package com.atguigu.netty.tcp;



import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * ChannelInitializer:
 * A special ChannelInboundHandler which offers an easy way to initialize a Channel once it was registered to its EventLoop.
 * 主要目的是为程序员提供了一个简单的工具，用于在某个Channel注册到EventLoop后，对这个Channel执行一些初始化操作，比如添加Handler.
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyServerHandler());
    }
}
