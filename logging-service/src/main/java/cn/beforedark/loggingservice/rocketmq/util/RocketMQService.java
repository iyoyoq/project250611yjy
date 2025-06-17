package cn.beforedark.loggingservice.rocketmq.util;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: mq服务
 * @Author: yjy
 * @Date: 2025/6/16 18:04
 */
@Component
public class RocketMQService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public boolean sendMessage(AddMessageReq addMessageReq) {
        //指定topic，tag
        rocketMQTemplate.convertAndSend(addMessageReq.getTopic() + ":" + addMessageReq.getTag(), addMessageReq.getMessage());
        return true;
    }

    public boolean syncSendMessage(AddMessageReq addMessageReq) {
        rocketMQTemplate.asyncSend(addMessageReq.getTopic(), addMessageReq.getMessage(), new SendCallback() {
            // 实现消息发送成功的后续处理
            public void onSuccess(SendResult var1) {
                System.out.println("async onSuccess" + var1);
            }
            // 实现消息发送失败的后续处理
            public void onException(Throwable var1) {
                System.out.println("async onException" + var1);
            }
        });
        return true;
    }
}
