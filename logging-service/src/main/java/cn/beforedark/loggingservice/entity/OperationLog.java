package cn.beforedark.loggingservice.entity;

import java.time.LocalDateTime;

/**
 * @Description: 操作日志
 * @Author: yjy
 * @Date: 2025/6/15 23:19
 */
public class OperationLog {
    private Long logId;
    private Long userId;
    private String action;
    private String ip;
    private String detail;
    private LocalDateTime operationTime;

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

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
}
