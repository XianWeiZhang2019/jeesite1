package com.thinkgem.jeesite.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TestMQ {
	
	public void name() {
		ConnectionFactory factory = new ConnectionFactory();
		//“guest”/“guest”默认情况下，仅限于localhost连接
		factory.setUsername("MQzhang");
		factory.setPassword("123456");
		factory.setVirtualHost("localhost");
		factory.setHost("localhost");
		factory.setPort(5672);

		try {
			Connection conn = factory.newConnection();
			Channel channel = conn.createChannel();
			DeclareOk response = channel.queueDeclarePassive("queue-name");
			//返回队列中处于Ready状态的消息数
			response.getMessageCount();
			System.out.println(response.getMessageCount());
			//返回队列拥有的消费者数量
			response.getConsumerCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取MQ连接
	public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("testhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
	private final static String QUEUE_NAME = "q_test_01";

   //生产者发送消息到队列
	public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
