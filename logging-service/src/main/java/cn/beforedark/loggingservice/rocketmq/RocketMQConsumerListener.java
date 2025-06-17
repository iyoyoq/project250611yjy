package cn.beforedark.loggingservice.rocketmq;

import cn.beforedark.loggingservice.entity.OperationLog;
import cn.beforedark.loggingservice.service.OperationService;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息监听器
 * @Author: yjy
 * @Date: 2025/6/16 18:02
 */
@Component
@RocketMQMessageListener(topic = "logging-service-topic", consumeMode = ConsumeMode.ORDERLY, consumerGroup = "${rocketmq.consumer.group}")
public class RocketMQConsumerListener implements RocketMQListener<OperationLog> {

    @Autowired
    private OperationService operationService;

    private static final Logger logger = LoggerFactory.getLogger(RocketMQConsumerListener.class);

    @Override
    public void onMessage(OperationLog operationLog) {
        // logger.info("接收到OperationLog, operationTime为{}", operationLog.getOperationTime());
        operationService.insert(operationLog);
    }

}
