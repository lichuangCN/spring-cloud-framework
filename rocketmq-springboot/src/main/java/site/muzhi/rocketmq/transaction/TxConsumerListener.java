package site.muzhi.rocketmq.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "order_consumer",topic = "order_topic")
public class TxConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("Receive message：" + message);
    }
}
