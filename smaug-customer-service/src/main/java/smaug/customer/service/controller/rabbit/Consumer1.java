package smaug.customer.service.controller.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <h3>smaug-cloud</h3>
 *
 * @auther 九品芝麻糊
 * @since 2020-03-28 15:28
 */
public class Consumer1 {
    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMqUtils.getConnection();

        Channel channel = connection.createChannel();
        channel.basicQos(1); //每次只能消费1个
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work", false, new DefaultConsumer(channel) {
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

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                channel.basicAck(envelope.getDeliveryTag(), false);

                System.out.println("consumer 1 body =>" + new String(body));
            }
        });
    }
}
