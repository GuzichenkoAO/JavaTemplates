package com.guzichenko.templates.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	private static final Logger LOGGER = Logger.getLogger(Sender.class);


	private static final String QUEUE_NAME = "Hello";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		// Specifying IP address of message broker
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello Mamba!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		LOGGER.info(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}
