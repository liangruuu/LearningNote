package com.atguigu.netty.tcp;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    /**
                     * 该 handler对应 bossGroup , childHandler 对应 workerGroup
                     * 在netty中可以简要地看成有三端：Client<——>Server_bossGroup<-->Server_workerGroup
                     * Client端使用.handler对应bossGroup，Server端使用.childHandler对应workerGroup
                     */
                    .handler(new MyClientInitializer()); //自定义一个初始化类

            ChannelFuture channelFuture = bootstrap.connect("localhost", 7000).sync();

            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
