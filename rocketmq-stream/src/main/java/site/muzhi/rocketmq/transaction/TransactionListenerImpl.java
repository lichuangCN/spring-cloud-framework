package site.muzhi.rocketmq.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "tx-producer-group", corePoolSize = 5, maximumPoolSize = 10)
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
    /**
     * 执行本地事务：即本地业务逻辑
     *
     * @param message
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        String num = String.valueOf(message.getHeaders().get("test"));
        if ("1".equals(num)) {
            log.error("execute: {} unknown.", new String((byte[]) message.getPayload()));
            return RocketMQLocalTransactionState.UNKNOWN;
        }
        if ("2".equals(num)) {
            log.error("execute: {} rollback.", new String((byte[]) message.getPayload()));
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        log.info("execute: {} commit.", new String((byte[]) message.getPayload()));
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
     * 回调检查
     *
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("check: {} ", new String((byte[]) message.getPayload()));
        return RocketMQLocalTransactionState.COMMIT;
    }
}
