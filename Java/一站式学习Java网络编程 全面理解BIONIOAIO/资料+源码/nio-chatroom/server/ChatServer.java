package server;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

public class ChatServer {

    private static final int DEFAULT_PORT = 8888;
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;

    private ServerSocketChannel server;
    private Selector selector;
    // 从通道读写数据都是需要经过Buffer的
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);
    // 写入其他用户通道
    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);
    private Charset charset = Charset.forName("UTF-8");
    private int port;

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
    }

    private void start() {
        try {
            // ServerSocketChannel.open()默认开启的是一个阻塞调用模式
            server = ServerSocketChannel.open();
            // 设置为非阻塞式调用，必做
            server.configureBlocking(false);
            // Channel关联的ServerSocket绑定到监听端口
            server.socket().bind(new InetSocketAddress(port));

            selector = Selector.open();
            /**
             * 告诉selector要监听哪一种状态变化
             * 在selector注册的第一个事件就是发生在ServerSocketChannel上的ACCEPT事件
             * ACCEPT事件触发在一个新的客户端发送一个连接请求到服务器端的时候
             */
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("启动服务器， 监听端口：" + port + "...");

            while (true) {
                /**
                 * select()的调用是阻塞性的，可能这个selector注册了多个Channel，但如果在调用select()过程中都没有selector监听的事件发生
                 * 那么这个select()是不会返回任何数的，select()返回的是有多少条满足条件的Channel被触发了
                 * public abstract int select() throws IOException;
                 */
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    /**
                     * 处理被触发的事件
                     * 客户端发送过来的数据和有关这个Channel的所有信息都被包装在SelectionKey中
                     */
                    handles(key);
                }
                /**
                 * 必须全部清空，因为进入下一次while循环的时候上一轮没有被清除的selectionKey会被继续加到新的selectionKeys集合里
                 * 而上一轮的selectionKey已经被handles处理过了
                 */
                selectionKeys.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(selector);
        }

    }

    private void handles(SelectionKey key) throws IOException {
        // ACCEPT事件 - 和客户端建立了连接
        if (key.isAcceptable()) {
            /**
             * SelectionKey对象包括了所有我们希望知道的有关触发事件相关的一切信息
             * 如果我们希望知道事件是在哪一个Channel上触发的就要调用key.channel()
             */
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            System.out.println(getClientName(client) + "已连接");
        }
        // READ事件 - 客户端发送了消息
        else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            String fwdMsg = receive(client);
            // 客户端接收的是空消息或者异常消息，那么服务端就没有接受的必要了
            if (fwdMsg.isEmpty()) {
                // 客户端异常，希望selector不要再监听这个通道上read事件了
                key.cancel();
                // 更新了selector监听的事件状态，所以把当前阻塞住的selector马上返回，重新监听
                selector.wakeup();
            } else {
                System.out.println(getClientName(client) + ":" + fwdMsg);
                forwardMessage(client, fwdMsg);

                // 检查用户是否退出
                if (readyToQuit(fwdMsg)) {
                    key.cancel();
                    selector.wakeup();
                    System.out.println(getClientName(client) + "已断开");
                }
            }

        }
    }

    // 把信息分发到别的客户端上（广播）
    private void forwardMessage(SocketChannel client, String fwdMsg) throws IOException {
        /**
         * SelectionKey上不仅仅只有SocketChannel，而且还有一开始注册的ServerSocketChannel，我们没有必要再把数据发送给ServerSocket
         * selector.keys()和之前的selector.selectedKeys()不一样
         * .keys()表示选定所有目前已经注册在selector上面的SelectionKeys集合而.selectedKeys()返回的是所有触发了事件的SelectionKeys集合
         */
        for (SelectionKey key : selector.keys()) {
            Channel connectedClient = key.channel();
            if (connectedClient instanceof ServerSocketChannel) {
                continue;
            }
            /**
             * 1. 其他客户端的SocketChannel未被关闭
             * 2. !client.equals(connectedClient)表示数据不会转发给它自己
             */
            if (key.isValid() && !client.equals(connectedClient)) {
                wBuffer.clear();
                wBuffer.put(charset.encode(getClientName(client) + ":" + fwdMsg));
                wBuffer.flip();
                while (wBuffer.hasRemaining()) {
                    ((SocketChannel) connectedClient).write(wBuffer);
                }
            }
        }
    }

    private String receive(SocketChannel client) throws IOException {
        rBuffer.clear();
        // 把从SocketChannel读出的数据写入rBuffer
        while (client.read(rBuffer) > 0) ;
        rBuffer.flip();
        return String.valueOf(charset.decode(rBuffer));
    }

    private String getClientName(SocketChannel client) {
        return "客户端[" + client.socket().getPort() + "]";
    }

    private boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    private void close(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(7777);
        chatServer.start();
    }
}
