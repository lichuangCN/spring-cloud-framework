package site.muzhi.rocketmq.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
public interface DefSource {
    /**
     * Name of the output channel.
     */
    String OUTPUT = "def-output";

    String TX_OUTPUT = "tx-output";

    /**
     * @return output channel
     */
    @Output(DefSource.OUTPUT)
    MessageChannel output();

    @Output(DefSource.TX_OUTPUT)
    MessageChannel outputTx();
}
