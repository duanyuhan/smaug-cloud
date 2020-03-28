package smaug.customer.service.controller.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/**
 * <h3>smaug-cloud</h3>
 *
 * @auther 九品芝麻糊
 * @since 2020-03-28 14:25
 */
public class RabbitMqUtils {
    public static Connection getConnection() {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("ems-host");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        //获取连接对象
        try {
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection, Channel channel) {
        try {


            if (Objects.nonNull(connection)) {
                connection.close();
            }
            if (Objects.nonNull(channel)) {
                channel.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
