package cn.beforedark.userservice.entity.dto;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/17 15:24
 */
public class UserLoginDto {
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
