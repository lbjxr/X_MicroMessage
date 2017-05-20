package com.x.service;


import com.x.dao.CommandDao;
import com.x.dao.MessageDao1;
import com.x.bean.Command;
import com.x.bean.CommandContent;
import com.x.bean.Message;
import com.x.util.Iconst;

import java.util.List;
import java.util.Random;

/**
 * Created by x on 2017/5/1.
 * 通过指令查询自动回复的内容
 */
public class QueryService {

    public List<Message> queryMessageList(String command, String description){
        MessageDao1 messageDao = new MessageDao1();
        return messageDao.queryMessageList(command,description);
    }

    public String queryByCommand(String command){
        CommandDao commandDao = new CommandDao();
        List<Command> commandList;
        if (Iconst.HELP_COMMAND.equals(command)){
            commandList = commandDao.queryCommandList(null,null);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i<commandList.size();i++){
                if (i != 0){
                    result.append("</br>");
                }
                result.append("回复【"+commandList.get(i).getName()+"]可以查看《"+commandList.get(i).getDescription()+"》");
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command,null);
        if(commandList.size() > 0){
            List<CommandContent> commandContents = commandList.get(0).getContentList();
            int i = new Random().nextInt(commandContents.size());
            return commandContents.get(i).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
