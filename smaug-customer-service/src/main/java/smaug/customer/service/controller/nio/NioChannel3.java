package smaug.customer.service.controller.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioChannel3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("/Users/ph/Desktop/1.txt");

        FileChannel channel1 = fileInputStream1.getChannel();

        FileOutputStream outputStream = new FileOutputStream("/Users/ph/Desktop/2.txt");
        FileChannel channel2 = outputStream.getChannel();

//        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
//
//        while (true) {
//            /**
//             * buffer 标志位重置
//             */
//            byteBuffer.clear();
//            int read = channel1.read(byteBuffer);
//            if (read == -1) {
//                break;
//            }
//            byteBuffer.flip();
//            channel2.write(byteBuffer);
//        }

        channel2.transferFrom(channel1, 0,channel1.size());


        fileInputStream1.close();
        outputStream.close();
    }
}
