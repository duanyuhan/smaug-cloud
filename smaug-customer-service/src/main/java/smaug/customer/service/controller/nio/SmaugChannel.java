package smaug.customer.service.controller.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SmaugChannel {
    public static void main(String[] args) throws IOException {
        String str = "hellow wotd";

        FileOutputStream stream = new FileOutputStream("/Users/ph/Desktop/1.txt");

        /**
         * 获取channel
         */
        FileChannel fileChannel = stream.getChannel();

        /**
         * 声明buffer
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        /**
         * 写入buffer
         */
        byteBuffer.put(str.getBytes());

        /**
         * 更新position 以便写入
         */
        byteBuffer.flip();

        /**
         * 写入 channel
         */
        fileChannel.write(byteBuffer);

        /**
         * 关闭流
         */
        stream.close();

    }
}
