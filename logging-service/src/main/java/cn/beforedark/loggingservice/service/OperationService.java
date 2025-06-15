package cn.beforedark.loggingservice.service;

import cn.beforedark.loggingservice.entity.OperationLog;

public interface OperationService {
    void insert(OperationLog record);
}
