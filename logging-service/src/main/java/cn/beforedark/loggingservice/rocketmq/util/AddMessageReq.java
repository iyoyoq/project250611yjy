package cn.beforedark.loggingservice.rocketmq.util;

/**
 * @Description: 发送RocketMQ消息请求实体类
 * @Author: yjy
 * @Date: 2025/6/16 18:02
 */
public class AddMessageReq {
    public AddMessageReq() {
    }

    public AddMessageReq(String topic, String tag, Message<String> message) {
        this.topic = topic;
        this.tag = tag;
        this.message = message;
    }

    private String topic;

    private String tag;

    private Message<String> message;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Message<String> getMessage() {
        return message;
    }

    public void setMessage(Message<String> message) {
        this.message = message;
    }
}
