package smaug.customer.service.controller.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <h3>smaug-cloud</h3>
 *
 * @auther 九品芝麻糊
 * @since 2020-03-28 13:43
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("ems-host");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        //获取连接对象
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", false, false, false, null);

        /**
         * 1 队列名称
         * 2 开启消息自动确认
         * 3 消费消息时的回调接口
         */
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            /**
             * 最后一个参数是消息队列中取出的队列
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.printf("body " + new String(body));
            }
        });

//        channel.close();
//        connection.close();


    }
}
