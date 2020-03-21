package smaug.customer.service.controller.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("/Users/ph/Desktop/1.txt");

        /**
         * 获取channel
         */
        FileChannel fileChannel = stream.getChannel();

        /**
         * 声明buffer
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        fileChannel.read(byteBuffer);
        /**
         * 一次性返回所有
         */
        System.out.println(new String(byteBuffer.array()));

        stream.close();
    }
}
