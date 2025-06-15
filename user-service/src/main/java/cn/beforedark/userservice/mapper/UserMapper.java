package cn.beforedark.userservice.mapper;


import cn.beforedark.userservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    Long registerByUsernameAndPassword(User user);
}
