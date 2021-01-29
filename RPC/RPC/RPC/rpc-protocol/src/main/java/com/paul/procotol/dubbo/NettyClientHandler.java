package com.paul.procotol.dubbo;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import com.paul.framework.MessageCallBack;
import com.paul.framework.RpcRequest;
import com.paul.framework.RpcResponse;
import com.paul.procotol.dubbo.channelpool.ResponseHolder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    private ChannelHandlerContext context;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("停止时间是："+new Date());
        System.out.println("HeartBeatClientHandler channelInactive");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.context = ctx;
        System.out.println("激活时间是："+ctx.channel().id());
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse) throws Exception {
        // String res = (String)msg;
        //RpcResponse rpcResponse = (RpcResponse)msg;
        String responseId = rpcResponse.getResponseId();
        MessageCallBack callBack = ResponseHolder.getInstance().mapCallBack.get(responseId);
        if(callBack != null){
            ResponseHolder.getInstance().mapCallBack.remove(responseId);
            callBack.over(rpcResponse);
        }
    }
}
