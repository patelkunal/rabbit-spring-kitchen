package org.coderearth.rabbitspringkitchen.basiclistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;

public class BasicListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicListener.class);

    @Override
    public void onMessage(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        LOGGER.info("<queue = {}, consumer_tag = {}> {}", messageProperties.getConsumerQueue(), messageProperties.getConsumerTag(),
                new String(message.getBody()).trim());
        // LOGGER.info("<queue = {}, consumer_tag = {}> {}", messageProperties.getConsumerQueue(), messageProperties.getConsumerTag(),
                // messageProperties.toString());
    }
}
