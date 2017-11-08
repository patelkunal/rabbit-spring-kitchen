package org.coderearth.rabbitspringkitchen.basiclistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("basic-listener-context.xml");
        LOGGER.info(applicationContext.getBean("foo.queue", Queue.class).toString());
        LOGGER.info(applicationContext.getBean("bar.queue", Queue.class).toString());
        LOGGER.info(applicationContext.getBean(ConnectionFactory.class).toString());
        LOGGER.info(applicationContext.getBean(BasicListener.class).toString());

        LOGGER.info("BasicListenerApplication has started !!");

    }

}
