package site.muzhi.rocketmq.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import site.muzhi.rocketmq.producer.DefSource;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private DefSource source;

    public <T> void sendTransactionMessage(T message, String num) {
        MessageBuilder<T> builder = MessageBuilder.withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .setHeader("test", num);
        //.setHeader(RocketMQHeaders.TAGS, "binder");
        Message<T> m = builder.build();
        source.outputTx().send(m);
    }
}
