package cn.beforedark.permissionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.beforedark.permissionservice.mapper")
public class PermissionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionServiceApplication.class, args);
    }

}
