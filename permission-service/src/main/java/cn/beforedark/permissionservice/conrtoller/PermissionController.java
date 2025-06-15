package cn.beforedark.permissionservice.conrtoller;

import cn.beforedark.permissionservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 绑定默认角色（普通用户）
     * @param userId 用户 id
     */
    @PostMapping("/bindDefaultRole")
    public Boolean bindDefaultRole (@RequestParam("userId") Long userId) {
        permissionService.bindDefaultRole(userId);
        return true;
    }


}
