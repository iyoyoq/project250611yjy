package cn.beforedark.userservice.service.impl;

import cn.beforedark.userservice.entity.db.User;
import cn.beforedark.userservice.entity.dto.UserLoginDto;
import cn.beforedark.userservice.entity.dto.UserRegisterDto;
import cn.beforedark.userservice.mapper.UserMapper;
import cn.beforedark.userservice.service.PermissionClient;
import cn.beforedark.userservice.service.UserService;
import cn.beforedark.userservice.util.IpAddressUtil;
import cn.beforedark.userservice.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
    @Autowired
    private LoggingMQService loggingMQService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(UserRegisterDto dto) {
        // 1. 校验用户名重复问题
        User userFromDb = userMapper.getByUsername(dto.getUsername());
        if (userFromDb != null) {
            return false;
        }

        // 2. 注册用户
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPasswordSalt(PasswordUtil.generateRandomString(16));
        user.setPassword(PasswordUtil.getSHA256Hash(dto.getPassword() + user.getPasswordSalt()));
        userMapper.registerByUsernameAndPassword(user);
        // 3. 绑定默认角色
        permissionClient.bindDefaultRole(user.getUserId());
        // 4.记录日志
        loggingMQService.sendMessage(new LoggingMQService.OperationLog(
                user.getUserId(),
                "用户注册",
                IpAddressUtil.getClientIpAddress(),
                "用户注册成功",
                LocalDateTime.now()
        ));
        return true;
    }

    @Override
    public boolean login(UserLoginDto dto) {
        // 1 校验密码
        User user = userMapper.getByUsername(dto.getUsername());
        if (user == null) {
            return false;
        }
        boolean loginSuccess = user.getPassword().equals(
                PasswordUtil.getSHA256Hash(
                        dto.getPassword() + user.getPasswordSalt()
                )
        );
        if (!loginSuccess) {
            return false;
        }
        // 2. 登录日志
        loggingMQService.sendMessage(new LoggingMQService.OperationLog(
                user.getUserId(),
                "用户登录",
                IpAddressUtil.getClientIpAddress(),
                "用户登录成功",
                LocalDateTime.now()

        ));
        return true;
    }
}
