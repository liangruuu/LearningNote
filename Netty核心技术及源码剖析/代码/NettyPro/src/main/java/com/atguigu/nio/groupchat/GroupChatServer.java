
package com.atguigu.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //构造器
    //初始化工作
    public GroupChatServer() {

        try {

            //得到选择器
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该listenChannel 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //监听
    public void listen() {

        System.out.println("监听线程: " + Thread.currentThread().getName());
        try {

            //循环处理
            while (true) {
                /**
                 * selector.select()是一个阻塞方法，当没有客户端请求时就会使线程处于阻塞状态
                 * 因为处于while循环体里，当selector处理完第一个客户端请求的时候就会再次执行这行代码，即线程重新陷入阻塞状态
                 *
                 * selector就像一个左轮手枪，每一次客户端的请求都会给这个同心圆添加一个"子弹口"
                 * 然后selector就在不停地转这个同心圆，一直转到某一个"子弹口"发生了某事件（read/write...）
                 * 当客户端断开连接的时候就删除这个同心圆的对应"子弹口"
                 *
                 * selector.select()阻塞就可以当成左轮手枪在疯狂地旋转，一直处于旋转状态直到转到了一个有子弹的子弹口就停下来
                 * 对应到程序上就是继续执行剩下的代码
                 *
                 * NIO是同步非阻塞的，但其实是阻塞的，同步非阻塞不是形容nio的select()
                 * 其实可以不用纠结阻塞和非阻塞这件事，是需要知道非阻塞可以只用一个线程，处理多个的客户端连接
                 * 而阻塞比如所BIO模式对于每一个客户端请求，服务器必须生成对应的一个线程去处理
                 *
                 * 至于ServerSocketChannel.configureBlocking(false);这行代码只需要知道如果不写就会抛出"错误的阻塞模型异常"就好了
                 * 因为必须设置通道为 非阻塞，才能向 Selector 注册
                 * 形象点来说必须使左轮手枪保持空转的状态，但是不能在没有遇到子弹的情况下停止转动
                 * 空转是阻塞，没有遇到遇子弹的停止也是阻塞，前者（同步非阻塞）是被允许的，后者（同步阻塞）是不被允许的
                 */
                int count = selector.select();
                if (count > 0) {//有事件处理

                    //遍历得到selectionKey 集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        //取出selectionkey
                        SelectionKey key = iterator.next();

                        //监听到accept
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            //将该 sc 注册到seletor
                            sc.register(selector, SelectionKey.OP_READ);

                            //提示
                            System.out.println(sc.getRemoteAddress() + " 上线 ");

                        }
                        if (key.isReadable()) { //通道发送read事件，即通道是可读的状态
                            //处理读 (专门写方法..)

                            readData(key);

                        }
                        //当前的key 删除，防止重复处理
                        iterator.remove();
                    }

                } else {
                    System.out.println("等待....");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //发生异常处理....

        }
    }

    //读取客户端消息
    private void readData(SelectionKey key) {

        //取到关联的channle
        SocketChannel channel = null;

        try {
            //得到channel
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            //根据count的值做处理
            if (count > 0) {
                //把缓存区的数据转成字符串
                String msg = new String(buffer.array());
                //输出该消息
                System.out.println("form 客户端: " + msg);

                //向其它的客户端转发消息(去掉自己), 专门写一个方法来处理
                sendInfoToOtherClients(msg, channel);
            }

        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了..");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                ;
            }
        }
    }

    //转发消息给其它客户(通道)
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {

        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());
        //遍历 所有注册到selector 上的 SocketChannel,并排除 self
        for (SelectionKey key : selector.keys()) {

            //通过 key  取出对应的 SocketChannel
            Channel targetChannel = key.channel();

            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {

                //转型
                SocketChannel dest = (SocketChannel) targetChannel;
                //将msg 存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer 的数据写入 通道
                dest.write(buffer);
            }
        }

    }

    public static void main(String[] args) {

        //创建服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}

//可以写一个Handler
class MyHandler {
    public void readData() {

    }

    public void sendInfoToOtherClients() {

    }
}

