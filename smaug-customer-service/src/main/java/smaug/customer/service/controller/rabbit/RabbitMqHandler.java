package smaug.customer.service.controller.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <h3>smaug-cloud</h3>
 *
 * @auther 九品芝麻糊
 * @since 2020-03-28 12:57
 */
@Component
public class RabbitMqHandler {

    public static void main(String[] args) throws IOException, TimeoutException {


        //获取连接对象
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 1 队列名字
         * 2 是否持久化 true 持久化
         * 3 是否独占队列-- 当前队列只允许当前连接使用
         * 4 autoDelete 队列是否自动删除
         * 5 附加参数
         */
        channel.queueDeclare("work", true, false, false, null);

        //发布消息
        /**
         * 1 交换机名称
         * 2 队列名称
         * 3 额外设置
         */
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "work", MessageProperties.PERSISTENT_BASIC, ("hello rabbit " + i).getBytes());

        }

        RabbitMqUtils.closeConnection(connection, channel);

    }
}
