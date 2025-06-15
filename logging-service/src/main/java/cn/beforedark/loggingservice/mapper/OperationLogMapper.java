package cn.beforedark.loggingservice.mapper;

import cn.beforedark.loggingservice.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {
    void insert(OperationLog record);
}
