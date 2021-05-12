package site.muzhi.rocketmq.transaction;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Slf4j
@Service
public class TxProducer {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    public <T> void sendTransactionMessage(T data, String flag) {

        Message<T> message = MessageBuilder.withPayload(data).build();
        log.info("send message: {}", JSONObject.toJSONString(message));

        // 发送事务消息
        TransactionSendResult result = rocketMQTemplate.sendMessageInTransaction("tx_producer_group", "order_topic", message, flag);
        log.info("send result: {}", JSONObject.toJSONString(result));
    }
}
