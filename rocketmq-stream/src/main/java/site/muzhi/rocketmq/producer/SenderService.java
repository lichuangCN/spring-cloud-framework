package site.muzhi.rocketmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Slf4j
@Service
public class SenderService {
    /*
     * Spring Cloud Stream中通过Source发送消息
     * Spring Boot中直接集成RocketMQ则是通过RocketMQTemplate发送消息
     */
    @Autowired
    private Source source;

    @Autowired
    private DefSource defSource;

    /**
     * 发送方法
     *
     * @param message
     */
    public void send(String message) {
        boolean flag = source.output().send(MessageBuilder.withPayload(message).build());
        log.info("发送消息结果：{}", flag);
    }

    /**
     * 自定义信道发送
     *
     * @param message
     */
    public void sendDef(String message) {
        boolean flag = defSource.output().send(MessageBuilder.withPayload(message).build());
        log.info("发送消息结果（自定义）：{}", flag);
    }

    public <T> void sendDefObject(T obj) {
        // Json格式
        MessageBuilder<T> builder = MessageBuilder.withPayload(obj)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE);
        Message<T> m = builder.build();
        boolean flag = defSource.output().send(m);
        log.info("发送消息结果：{}", flag);
    }

    /**
     * 带有tag标签
     *
     * @param tag
     * @param <T>
     */
    public <T> void sendDefWithTags(T obj, String tag) {
        // Json格式
        MessageBuilder<T> builder = MessageBuilder.withPayload(obj)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .setHeader(RocketMQHeaders.TAGS, tag);
        Message<T> m = builder.build();
        boolean flag = defSource.output().send(m);
        log.info("发送消息结果：{}", flag);
    }
}
