package site.muzhi.rocketmq.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import site.muzhi.rocketmq.comsumer.DefSink;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Slf4j
@Service
public class Receiver {

    @StreamListener(value = DefSink.TX_INPUT)
    public void receive(String message) {
        log.info("接收到的事务信息：{}", message);
    }
}
