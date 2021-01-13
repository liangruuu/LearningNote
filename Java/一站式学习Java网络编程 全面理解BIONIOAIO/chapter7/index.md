## 1. 使用NIO实现多人聊天室

![1581752684503](assets/1581752684503.png)

![1581750564018](assets/1581750564018.png)

1. 内置服务器的ServerSocket Channel，注册一个Accept事件；希望让Selector一直监听ServerSocket Channel的Accept事件的发生，类似于BIO中`server.accept()`
2. 当有客户端连接成功时，Selector就能监听到ServerSocket Channel触发了Accept事件，然后就要为这个ServerSocket Channel在Selector上注册一个新事件READ，READ结合之前Channel状态，意思为Selector监听这个ServerSocket Channel是否触发了READ事件，即服务器端接受从客户端发送过来的数据后，该客户端的Channel上就有可供服务器端读取的数据，即Channel的状态为READ
3. 以上处理过程都是和Selector在同一个线程上(与BIO不同)

参考代码 nio-chatroom

![1581754914421](assets/1581754914421.png)