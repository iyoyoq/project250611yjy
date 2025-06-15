package cn.beforedark.loggingservice.service.impl;

import cn.beforedark.loggingservice.entity.OperationLog;
import cn.beforedark.loggingservice.mapper.OperationLogMapper;
import cn.beforedark.loggingservice.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/15 23:21
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public void insert(OperationLog record) {
        operationLogMapper.insert(record);
    }
}
