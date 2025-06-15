package cn.beforedark.userservice.controller;

import cn.beforedark.userservice.entity.dto.UserRegisterDto;
import cn.beforedark.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 用户接口
 * @Author: yjy
 * @Date: 2025/6/12 14:46
 */

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "User Service";
    }


    @PostMapping("/user/register")
    public Boolean userRegister(@RequestBody UserRegisterDto dto) {
        boolean result = userService.register(dto);
        return result;
    }



}
