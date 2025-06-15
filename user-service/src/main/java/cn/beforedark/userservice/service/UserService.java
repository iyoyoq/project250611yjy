package cn.beforedark.userservice.service;

import cn.beforedark.userservice.entity.dto.UserRegisterDto;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/13 19:27
 */
public interface UserService {
    boolean register(UserRegisterDto dto);
}
