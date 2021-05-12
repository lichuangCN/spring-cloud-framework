package site.muzhi.rocketmq.base;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Slf4j
@Service
public class Producer {

    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @Value("${mq.test.topic}")
    private String topic;

    public <T> void sendMessage(T obj) {
        String data = JSONObject.toJSONString(obj);
        SendResult result = rocketMQTemplate.syncSend(topic, data);
        log.info("send result: {}", JSONObject.toJSONString(result));
    }

    public <T> void sendObj(T obj) {
        SendResult result = rocketMQTemplate.syncSend(topic, obj);
        log.info("send result: {}", JSONObject.toJSONString(result));
    }
}
