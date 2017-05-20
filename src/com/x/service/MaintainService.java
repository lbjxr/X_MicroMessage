package com.x.service;


import com.x.dao.MessageDao1;
import com.x.bean.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2017/5/1.
 * 维护相关业务功能
 */
public class MaintainService {

    MessageDao1 messageDao = new MessageDao1();
    /**
     *单条删除
     */
    public void deleteOne(String id){
        if (id != null && !"".equals(id.trim())){

            messageDao.deleteOne(Integer.valueOf(id));
        }

    }

    /**
     *多条删除
     */
    public void deleteBatch(String[] ids) {
        List<Integer> idlist = new ArrayList<Integer>();
        if (ids != null) {
            for (String id : ids) {
                idlist.add(Integer.valueOf(id));
            }
            messageDao.deleteBatch(idlist);
        }else {

        }
    }

    /**
     * 修改内容
     * */
    public void addInfo(String command, String description, String content){

        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        messageDao.addInfo(message);

    }
}
