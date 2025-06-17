package cn.beforedark.userservice.controller;

import cn.beforedark.userservice.entity.dto.UserLoginDto;
import cn.beforedark.userservice.entity.dto.UserRegisterDto;
import cn.beforedark.userservice.entity.sys.Resp;
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


    @PostMapping("/user/register")
    public Resp userRegister(@RequestBody UserRegisterDto dto) {
        boolean flag = userService.register(dto);
        if ( flag){
            return Resp.ok("注册成功");
        }
        return Resp.err("注册失败");
    }

    @PostMapping("/user/login")
    public Resp userLogin(@RequestBody UserLoginDto dto) {
        boolean flag = userService.login(dto);
        if ( flag){
            return Resp.ok("登录成功");
        }
        return Resp.err("登录失败");
    }

}
