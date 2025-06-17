package cn.beforedark.loggingservice.rocketmq.util;

/**
 * @Description: 消息体
 * @Author: yjy
 * @Date: 2025/6/16 18:01
 */
public class Message<T> {
    public Message(String id, T content) {
        this.id = id;
        this.content = content;
    }
    public Message() {}
    private String id;
    private T content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
