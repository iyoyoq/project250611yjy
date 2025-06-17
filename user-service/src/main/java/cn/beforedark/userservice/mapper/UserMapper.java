package cn.beforedark.userservice.mapper;


import cn.beforedark.userservice.entity.db.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {


    Long registerByUsernameAndPassword(User user);

    User getByUsername(@Param("username") String username);
}
