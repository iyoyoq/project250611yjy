package cn.beforedark.userservice.service.impl;

import cn.beforedark.userservice.entity.User;
import cn.beforedark.userservice.entity.dto.UserRegisterDto;
import cn.beforedark.userservice.mapper.UserMapper;
import cn.beforedark.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/13 19:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(UserRegisterDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        userMapper.registerByUsernameAndPassword(user);

        return true;
    }
}
