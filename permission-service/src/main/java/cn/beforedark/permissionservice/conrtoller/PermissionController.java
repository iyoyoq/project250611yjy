package cn.beforedark.permissionservice.conrtoller;

import cn.beforedark.permissionservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/test")
    public String test() {
        return "Permission Service";
    }

    /**
     * 绑定默认角色（普通用户）
     * @param userId 用户 id
     */
    @PostMapping("/bindDefaultRole")
    public Boolean bindDefaultRole (Long userId) {
        permissionService.bindDefaultRole(userId);
        return true;
    }


}
