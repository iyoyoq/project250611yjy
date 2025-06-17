package cn.beforedark.loggingservice;

import cn.beforedark.loggingservice.rocketmq.util.AddMessageReq;
import cn.beforedark.loggingservice.rocketmq.util.Message;
import cn.beforedark.loggingservice.rocketmq.util.RocketMQService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggingServiceApplicationTests {

    @Autowired
    private RocketMQService rocketMQService;

    @Test
    void mqTest() throws InterruptedException {
        rocketMQService.sendMessage(
                new AddMessageReq("loggerTopic", "tag1",
                        new Message<>("1", "hello world")
                )
        );
        Thread.sleep(200 *1000);
    }

}
