package cn.beforedark.userservice.service.impl;

import cn.beforedark.userservice.entity.User;
import cn.beforedark.userservice.entity.dto.UserRegisterDto;
import cn.beforedark.userservice.mapper.UserMapper;
import cn.beforedark.userservice.service.PermissionClient;
import cn.beforedark.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/13 19:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionClient permissionClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(UserRegisterDto dto) {
        // 1. 注册用户
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        userMapper.registerByUsernameAndPassword(user);
        // 2. 绑定默认角色
        permissionClient.bindDefaultRole(user.getUserId());
        // 3.记录日志

        return true;
    }
}
