package org.coderearth.rabbitspringkitchen.recipe01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        LOGGER.info(applicationContext.getBean(Queue.class).toString());
        LOGGER.info(applicationContext.getBean(ConnectionFactory.class).toString());
        LOGGER.info(applicationContext.getBean(Recipe01Listner.class).toString());
    }

}
