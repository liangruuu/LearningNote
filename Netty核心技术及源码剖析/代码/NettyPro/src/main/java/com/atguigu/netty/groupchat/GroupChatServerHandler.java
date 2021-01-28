package com.atguigu.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //public static List<Channel> channels = new ArrayList<Channel>();

    //使用一个hashmap 管理
    //public static Map<String, Channel> channels = new HashMap<String,Channel>();

    //定义一个channle 组，管理所有的channel
    //GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
    private static ChannelGroup  channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * handlerAdded 表示连接建立，一旦连接，第一个被执行，将当前channel 加入到  channelGroup
     * # handlerAdded和channelActive的区别
     * 正如代码所示，我们在handlerAdded和channelActive方法中均写了相同的代码，结果也是相同的。那么在两者内分别定义相同的代码又有什么区别呢？
     * 我们先来分析整个数据传输过程
     * pdf文档的#6.6 3)中写道：在 Netty 中每个 Channel 都有且仅有一个 ChannelPipeline 与之对应；而ChannelPipeline是一个存放若干Handler的集合
     * 看到这里可能会感到奇怪：明明Handler是通用的，即只要一开始就定义好了Handler，以后不管有多少个Channel被创建都是能被已创建好的Handler所处理的
     * 我们需要看一下源码
     * GroupChatServer类中对ServerBootstrap初始化时的childHandler需要传进去ChannelInitializer
     * 而ChannelInitializer需要重写initChannel方法
     * 有一个误区需要澄清一点，虽然ServerBootstrap是一个创建初始化的类，但是其中的ChannelInitializer并不是只在一开始被调用
     * 我们一般认为既然是初始化的类，那就只会在一开始全部设置好配置参数，但是这里并非如此，它是在每当有客户端请求创建Channel时就调用
     * 所以每当有客户端请求的时候都会调用initChannel体内的代码，而initChannel体内有addLast方法，意味着每次都会在ChannelPipeline添加handler
     * 而且因为一个channel对应一个唯一的ChannelPipeline，所以是在一个新创建的ChannelPipeline里添加handler
     * 既然添加了handler，那就肯定会调用时间周期函数handlerAdded
     *
     * 同理对于Client端的GroupChatClientHandler也是如此
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入聊天的信息推送给其它在线的客户端
        /*
        该方法会将 channelGroup 中所有的channel 遍历，并发送 消息，
        我们不需要自己遍历
         */
        channelGroup.add(channel);
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 加入聊天" + sdf.format(new java.util.Date()) + " \n");

    }

    //断开连接, 将xx客户离开信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 离开了\n");
        System.out.println("channelGroup size" + channelGroup.size());

    }

    /**
     * 表示channel 处于活动状态, 提示 xx上线
     * 集合pdf文档中#5.8.4的示意图，当客户端申请连接的时候会把channel注册到selector
     * 此时的channel处于激活状态
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        Channel channel = ctx.channel();
//        //将该客户加入聊天的信息推送给其它在线的客户端
//        /*
//        该方法会将 channelGroup 中所有的channel 遍历，并发送 消息，
//        我们不需要自己遍历
//         */
//        channelGroup.add(channel);
//        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 加入聊天" + sdf.format(new java.util.Date()) + " \n");

        System.out.println(ctx.channel().remoteAddress() + " 上线了~");
    }

    //表示channel 处于不活动状态, 提示 xx离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + " 离线了~");
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        //获取到当前channel
        Channel channel = ctx.channel();
        //这时我们遍历channelGroup, 根据不同的情况，回送不同的消息

        channelGroup.forEach(ch -> {
            if(channel != ch) { //不是当前的channel,转发消息
                ch.writeAndFlush("[客户]" + channel.remoteAddress() + " 发送了消息" + msg + "\n");
            }else {//回显自己发送的消息给自己
                ch.writeAndFlush("[自己]发送了消息" + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }
}
