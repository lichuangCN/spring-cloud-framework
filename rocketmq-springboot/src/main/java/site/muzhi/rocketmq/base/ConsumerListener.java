package site.muzhi.rocketmq.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "${mq.test.topic}",
        consumerGroup = "${mq.test.consumer.group}",
        messageModel = MessageModel.BROADCASTING)
public class ConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Receive message：" + message);
    }
}
