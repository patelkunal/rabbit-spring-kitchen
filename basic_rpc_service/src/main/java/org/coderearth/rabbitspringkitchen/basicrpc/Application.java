package org.coderearth.rabbitspringkitchen.basicrpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by kunal_patel on 17/11/17.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("basic-rpc-context.xml");
        Assert.notNull(applicationContext, "ApplicationContext cannot be null !!");
        LOGGER.info("BasicRPCApplication has started !!");
    }

}
