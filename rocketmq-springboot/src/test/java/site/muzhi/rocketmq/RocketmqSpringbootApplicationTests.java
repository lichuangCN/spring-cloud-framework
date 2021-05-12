package site.muzhi.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.muzhi.rocketmq.base.Producer;
import site.muzhi.rocketmq.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RocketmqSpringbootApplication.class})
public class RocketmqSpringbootApplicationTests {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Autowired
    private Producer producer;

    @Test
    public void test() {

        User user = new User();
        user.setName("Jack");
        user.setAge(22);
        producer.sendObj(user);
        producer.sendMessage(user);
    }

}
