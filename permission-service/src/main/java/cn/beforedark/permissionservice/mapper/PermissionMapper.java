package cn.beforedark.permissionservice.mapper;


import cn.beforedark.permissionservice.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {

    Long insert(UserRole entity);

}
