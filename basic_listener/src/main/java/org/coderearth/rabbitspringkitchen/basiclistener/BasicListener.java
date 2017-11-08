package org.coderearth.rabbitspringkitchen.basiclistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class BasicListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicListener.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info(message.toString());
        LOGGER.info(new String(message.getBody()));
        LOGGER.info(message.getMessageProperties().toString());
    }
}
