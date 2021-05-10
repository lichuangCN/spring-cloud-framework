package site.muzhi.rocketmq.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
public interface DefSink {

    /**
     * Input channel name.
     */
    String INPUT = "def-input";
    String TX_INPUT = "tx-input";
    /**
     * @return input channel.
     */
    @Input(DefSink.INPUT)
    SubscribableChannel input();

    @Input(DefSink.TX_INPUT)
    SubscribableChannel inputTx();
}
