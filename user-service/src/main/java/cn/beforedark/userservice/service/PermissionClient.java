package cn.beforedark.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/15 19:51
 */
@FeignClient("permission-service")
public interface PermissionClient {


    @PostMapping("/bindDefaultRole")
    Boolean bindDefaultRole(@RequestParam("userId") Long userId);

}
