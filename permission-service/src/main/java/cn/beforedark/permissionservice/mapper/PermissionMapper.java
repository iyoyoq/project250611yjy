package cn.beforedark.permissionservice.mapper;


import cn.beforedark.permissionservice.entity.UserRoles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {

    long insert(UserRoles entity);

}
