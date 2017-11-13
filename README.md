### rabbit-spring-kitchen


##### basic_listener
* bare minimum configuration for listening message from given queues


##### consumer_listener
* tryouts and learning about configuration for concurrently listening messages from given queues

```bash
# perf-test command to check listener configuration/spring-application
rabbitmq-perf-test-1.4.0/bin/runjava com.rabbitmq.perf.PerfTest -h amqp://guest:guest@localhost:5672 -x 5 -p -u foo.queue,bar.queue -C 10 -B foo.msg -a -y0
```
