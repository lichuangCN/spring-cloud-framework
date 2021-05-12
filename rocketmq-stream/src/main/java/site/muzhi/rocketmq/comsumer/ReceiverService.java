package site.muzhi.rocketmq.comsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Slf4j
@Service
public class ReceiverService {
    @Autowired
    private Sink sink;

    /**
     * 普通方法接收，只接收一次
     */
    public void receive() {
        sink.input().subscribe((Message<?> message) -> {
            log.info("普通方法接收到的信息：{}", message.getPayload());
        });
    }

    /**
     * 监听器方式（推荐）
     */
    @StreamListener(value = Sink.INPUT)
    public void receive(String message) {
        log.info("监听器方式接收到的信息：{}", message);
    }

    /**
     * 监听器方式（推荐）
     */
    @StreamListener(value = DefSink.INPUT)
    public void receiveDef(String message) {
        log.info("监听器方式接收到的信息（自定义）：{}", message);
    }
}
