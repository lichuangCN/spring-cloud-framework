package site.muzhi.rocketmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.muzhi.rocketmq.transaction.TxProducer;

@SpringBootApplication
public class RocketmqSpringbootApplication implements CommandLineRunner {


    @Autowired
    private TxProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(RocketmqSpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        producer.sendTransactionMessage("user 1", "1");
        producer.sendTransactionMessage("user 2", "2");
        producer.sendTransactionMessage("user 3", "3");
        producer.sendTransactionMessage("user 4", "4");
    }
}
