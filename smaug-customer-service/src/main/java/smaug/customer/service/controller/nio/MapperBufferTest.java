package smaug.customer.service.controller.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapperBufferTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/ph/Desktop/1.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        /**
         * FileChannel.MapMode.READ_WRITE 适用读写模式
         * position 起始位置
         * size 映射到内存的大小 不是索引位置
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');

        randomAccessFile.close();
    }
}
