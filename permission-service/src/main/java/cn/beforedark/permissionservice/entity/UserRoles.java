package cn.beforedark.permissionservice.entity;

/**
 * @Description: UserRoles 表实体类
 * @Author: yjy
 * @Date: 2025/6/13 18:00
 */
public class UserRoles {

    private Long id;
    private Long userId;
    private Integer roleId;

    public UserRoles(Long userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
