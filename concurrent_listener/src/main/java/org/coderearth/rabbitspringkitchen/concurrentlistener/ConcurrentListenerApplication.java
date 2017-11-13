package org.coderearth.rabbitspringkitchen.concurrentlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;

public class ConcurrentListenerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentListenerApplication.class);

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("concurrent-listener-context.xml");
        LOGGER.info(applicationContext.getBean("foo.queue", Queue.class).toString());
        LOGGER.info(applicationContext.getBean("bar.queue", Queue.class).toString());
        LOGGER.info(applicationContext.getBean(ConnectionFactory.class).toString());
        LOGGER.info(applicationContext.getBean(ConcurrentListener.class).toString());
        // final ThreadPoolTaskExecutor executor = applicationContext.getBean(ThreadPoolTaskExecutor.class);
        // LOGGER.info(executor.toString());

        LOGGER.info("ConcurrentListenerApplication has started !!");
    }

}
