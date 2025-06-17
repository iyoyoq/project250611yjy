package cn.beforedark.userservice.entity.sys;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/18 0:42
 */
public class Resp<T> {
    private Integer status;
    private T result;

    public Resp(Integer status, T result) {
        this.status = status;
        this.result = result;
    }

    public static <T> Resp<T> ok(T result)  {
        return new Resp<>(0, result);
    }

    public static <T> Resp<T> err(T result)  {
        return new Resp<>(1, result);
    }

    public Resp() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
