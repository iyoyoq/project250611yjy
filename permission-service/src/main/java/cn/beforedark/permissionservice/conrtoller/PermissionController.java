package cn.beforedark.permissionservice.conrtoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 权限服务接口
 * @Author: yjy
 * @Date: 2025/6/13 11:53
 */
@RestController
@RequestMapping
public class PermissionController {
    @GetMapping("/test")
    public String test() {
        return "Permission Service";
    }


}
