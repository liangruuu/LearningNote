package com.atguigu.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/*
说明
1. SimpleChannelInboundHandler 继承自 ChannelInboundHandlerAdapter
    channelRead0方法在channelRead方法中被调用
2. HttpObject 客户端和服务器端相互通讯的数据被封装成 HttpObject
3. 这里采用继承ChannelInboundHandler而不是继承ChannelOutboundHandler是因为
    channelRead0方法体里主要做的是将构建好 response返回，即向客户端写数据，如果涉及到向客户端写数据就需要使用Inbound
    如果是向服务端写数据就需要使用Outbound，典型例子参考MessageToByteEncoder类，该类继承自ChannelOutboundHandlerAdapter
    虽然名字中不带Handler，但的确是一个Handler，所以之后需要被放入channelPipeLine中
    该类的作用就是把从客户端传过来的数据转化成字节（Byte）类型数据，是向服务端写数据，所以需要使用Outbound
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    //channelRead0 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {


        System.out.println("对应的channel=" + ctx.channel() + " pipeline=" + ctx
                .pipeline() + " 通过pipeline获取channel" + ctx.pipeline().channel());

        System.out.println("当前ctx的handler=" + ctx.handler());

        //判断 msg 是不是 httprequest请求
        if (msg instanceof HttpRequest) {

            System.out.println("ctx 类型=" + ctx.getClass());

            System.out.println("pipeline hashcode" + ctx.pipeline().hashCode() + " TestHttpServerHandler hash=" + this.hashCode());

            System.out.println("msg 类型=" + msg.getClass());
            System.out.println("客户端地址" + ctx.channel().remoteAddress());

            //获取到
            HttpRequest httpRequest = (HttpRequest) msg;
            //获取uri, 过滤指定的资源
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 favicon.ico, 不做响应");
                return;
            }
            //回复信息给浏览器 [http协议]

            ByteBuf content = Unpooled.copiedBuffer("hello, 我是服务器", CharsetUtil.UTF_8);

            //构造一个http的相应，即 httpresponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            //将构建好 response返回
            ctx.writeAndFlush(response);

        }
    }


}
