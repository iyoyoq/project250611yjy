package cn.beforedark.userservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.util.List;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/17 1:09
 */
@Configuration
public class RocketMQConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    @Primary
    public RocketMQMessageConverter enhanceRocketMQMessageConverter(){
        RocketMQMessageConverter converter = new RocketMQMessageConverter();
        CompositeMessageConverter compositeMessageConverter = (CompositeMessageConverter) converter.getMessageConverter();
        List<MessageConverter> messageConverterList = compositeMessageConverter.getConverters();

        for (MessageConverter messageConverter : messageConverterList) {
            if(messageConverter instanceof MappingJackson2MessageConverter){
                MappingJackson2MessageConverter jackson2MessageConverter = (MappingJackson2MessageConverter) messageConverter;
                jackson2MessageConverter.setObjectMapper(objectMapper);
            }
        }
        return converter;
    }
}
