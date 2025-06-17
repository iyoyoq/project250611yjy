package cn.beforedark.userservice.service.impl;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Description: 日志消息服务
 * @Author: yjy
 * @Date: 2025/6/16 21:23
 */
@Component
public class LoggingMQService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(OperationLog log) {
        rocketMQTemplate.convertAndSend("logging-service-topic", log);
    }

    public static class OperationLog {
        public OperationLog(Long userId, String action, String ip, String detail, LocalDateTime operationTime) {
            this.userId = userId;
            this.action = action;
            this.ip = ip;
            this.detail = detail;
            this.operationTime = operationTime;
        }

        public OperationLog() {
        }

        private Long userId;
        private String action;
        private String ip;
        private String detail;
        private LocalDateTime operationTime;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public LocalDateTime getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(LocalDateTime operationTime) {
            this.operationTime = operationTime;
        }
    }
}
