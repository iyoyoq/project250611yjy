package cn.beforedark.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户接口
 * @Author: yjy
 * @Date: 2025/6/12 14:46
 */

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "User Service";
    }


    @PostMapping("/user/register")
    public String userRegister() {
        return "保存用户成功";
    }



}
