package cn.beforedark.userservice.entity.dto;

/**
 * @Description: 用户注册 dto
 * @Author: yjy
 * @Date: 2025/6/13 19:25
 */
public class UserRegisterDto {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
