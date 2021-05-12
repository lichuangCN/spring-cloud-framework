package site.muzhi.rocketmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import site.muzhi.rocketmq.comsumer.DefSink;
import site.muzhi.rocketmq.comsumer.ReceiverService;
import site.muzhi.rocketmq.producer.DefSource;
import site.muzhi.rocketmq.producer.SenderService;
import site.muzhi.rocketmq.transaction.Sender;

@EnableBinding({Source.class, Sink.class, DefSource.class, DefSink.class})
@SpringBootApplication
public class RocketmqStreamApplication implements CommandLineRunner {

    @Autowired
    SenderService senderService;
    @Autowired
    ReceiverService receiverService;
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(RocketmqStreamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //senderService.send("hello,world");
        //senderService.sendDef("hello,world, def");
        //receiverService.receive();

        // 事务消息
        sender.sendTransactionMessage("tx message 1", "1");
        sender.sendTransactionMessage("tx message 2", "2");
        sender.sendTransactionMessage("tx message 3", "3");
        sender.sendTransactionMessage("tx message 4", "4");

        //senderService.sendDefObject(User.builder().name("HacJack").age(23).gender("male").build());
        //senderService.sendDefWithTags(User.builder().name("HacJack").age(23).gender("male").build(), "tag1");
        //senderService.sendDefWithTags(User.builder().name("HacJack").age(23).gender("male").build(), "tag2");
    }
}
