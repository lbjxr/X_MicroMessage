package com.x.bean;

/**
 * Created by x on 2017/5/1.
 * 与消息表对应的实体类
 */
public class Message {

    private String id;  //表中的主键
    private String command;     //查询指令
    private String description;     //字段描述
    private String content;     //结果内容


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
