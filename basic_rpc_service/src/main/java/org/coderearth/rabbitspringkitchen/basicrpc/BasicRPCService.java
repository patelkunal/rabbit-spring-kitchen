package org.coderearth.rabbitspringkitchen.basicrpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kunal_patel on 17/11/17.
 */
@Component
public class BasicRPCService implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicRPCService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void onMessage(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        LOGGER.info("<queue = {}, consumer_tag = {}, reply-to = {}, correlation-id = {}, body = {}>",
                messageProperties.getConsumerQueue(), messageProperties.getConsumerTag(),
                messageProperties.getReplyTo(), messageProperties.getCorrelationId(),
                (message.getBody() == null || message.getBody().length == 0) ? "NULL" : new String(message.getBody()).trim());
        rabbitTemplate.send(messageProperties.getReplyTo(), new Message(message.getBody(), new MessageProperties()));
    }
}
