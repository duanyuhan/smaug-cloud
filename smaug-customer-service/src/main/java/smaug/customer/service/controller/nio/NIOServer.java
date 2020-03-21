package smaug.customer.service.controller.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个selector 对象
        Selector selector = Selector.open();

        //绑定一个6666端口server
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        //非阻塞
        serverSocketChannel.configureBlocking(false);

        //serverSocketChannel 注册到 selecotr
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 等待1s 如果没有事件放生 返回
            if (selector.select(1000) == 0) { //没有事件发生
                System.out.println("没有时间发生 返回");
                continue;
            }
            /**
             * 1 如果 selector.select(1000) >0 则表示有事件发生
             * 2 selector.selectedKeys() 返回关注事件的集合
             * 3 通过SelectionKey 反向获取通道
             */

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                //根据key 对应的通道作相应的处理
                if (selectionKey.isAcceptable()) {//有客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将socketChannel 设置成非阻塞
                    socketChannel.configureBlocking(false);
                    // 将 socketChannel 注册到 selector
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(512));
                }
                if (selectionKey.isReadable()) {
                    //通过 selectionKey 反向获取channel
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //获取channel 关联的bugffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    channel.read(byteBuffer);
                    System.out.println("from 客户端  => " +new String( byteBuffer.array()));
                }
                //手动移出key
                keyIterator.remove();
            }
        }
    }
}
