package cn.beforedark.loggingservice.controller;

import cn.beforedark.loggingservice.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/15 23:21
 */
@RequestMapping
@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;
}
