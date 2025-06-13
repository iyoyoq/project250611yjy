package cn.beforedark.permissionservice.service.impl;

import cn.beforedark.permissionservice.mapper.PermissionMapper;
import cn.beforedark.permissionservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/13 13:22
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void bindDefaultRole(Long userId) {

    }


}
