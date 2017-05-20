package com.x.bean;

import java.util.List;

/**
 * 与指令表对应的实体类
 */
public class Command {
    /**
     * 主键
     */
    private int id;
    /**
     * 指令名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 一条指令对应的自动回复内容列表
     */
    private List<CommandContent> contentList;

    /**
     * Command集合
     */
    private List<Command> commandList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

}