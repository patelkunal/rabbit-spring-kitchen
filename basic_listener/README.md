#### rabbitmq queue basic listner

##### specifications
1. spring-amqp based
2. declare a queue along with MessageListener to listen incoming messages and print them


##### learnings
1. RabbitAdmin bean is required if you want to declare a queue
2. If just plain simple queue listener -
    * RabbitTemplate bean is not required
    * Exchange declaration and queue binding is not required, those are required when you want to publish messages
        - in-short MessageListerner is based on queue not on exchange
3. Required wiring for BasicListener
    * context:component-scan if required (when you are using annotation based spring configuration)
    * rabbit:connection-factory
        - declare connection-factory which will be shared across entire spring context to communicate with rabbitmq
    * rabbit:admin
        - declare RabbitAdmin which has to be present to declare a queue, if you are declaring new queue
        - RabbitAdmin is not required if you already have durable queue declared on the system - but its advisable to declare this.
          Sometimes when new RabbitMq servers are added without backup - in that case, binding will not happen
    * MessageListener bean
        - message consumer - basically a function which will be executed when any message arrives on the particular queue
    * rabbit:queue
        - declare Queue on which MessageListener will be registered
        - multiple queues can be declared by adding another entry of <rabbit:queue ...>
    * rabbit:listener-container and rabbit:listener
        - final wiring for everything, BRIDGE between MessageListener (callback function) and Queue     
        - same listener can be used for consuming message from multiple queues
