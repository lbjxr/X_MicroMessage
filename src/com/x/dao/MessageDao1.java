package com.x.dao;

import com.x.bean.Command;
import com.x.bean.CommandContent;
import com.x.bean.Message;
import com.x.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2017/5/11.
 */
public class MessageDao1 {
    public List<Message> queryMessageList(String command, String description) {

        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        DBAccess dbAccess = new DBAccess();
        try {
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            sqlSession = dbAccess.getSqlSession();
            //通过sqlsession执行SQL语句
            messageList = sqlSession.selectList("Message.queryMessageList", message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }


    /**
     * 单条删除
     */
    public void deleteOne(int id) {

        SqlSession sqlSession = null;
        DBAccess dbAccess = new DBAccess();
        try {
            sqlSession = dbAccess.getSqlSession();
            //通过sqlsession执行SQL语句
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 多条删除
     */
    public void deleteBatch(List<Integer> ids) {

        SqlSession sqlSession = null;
        DBAccess dbAccess = new DBAccess();
        try {
            sqlSession = dbAccess.getSqlSession();
            //通过sqlsession执行SQL语句
            sqlSession.delete("Message.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    /**
     * 消息添加
     * */

    public void addInfo(Message message){
        SqlSession sqlSession = null;
        DBAccess dbAccess = new DBAccess();


        /**
         * 查询command表中是否存在待插入的命令
         * 如果存在，更新COMMAND_CONTENT表中对应命令的内容条目
         * 如果不存在，向command表中插入新的命令，并且添加命令的内容到COMMAND_CONTENT表中
         */

        //通过sqlsession查询command表中的记录
        //查询command表中的条目
        Command command = new Command();
        CommandContent commandContent = new CommandContent();
        try {
            sqlSession=dbAccess.getSqlSession();

            command.setCommandList(sqlSession.selectList("Command.queryName"));

            //遍历查找是否存在待插入的命令
            for (int i = 0; i < command.getCommandList().size(); i++){
                if (command.getCommandList().get(i).getName().equals(message.getCommand().trim())){
                    //command表中存在这条命令
                    //取得这条命令的ID，作为command_content表中COMMAND_ID的值
                    commandContent.setContent(message.getContent());
                    commandContent.setCommandId(command.getCommandList().get(i).getId());
                    sqlSession.insert("CommandContent.addCommandContent",commandContent);
                    sqlSession.commit();
                }
                else{       //command表中不存在这个命令

                    //通过sqlsession执行sql语句,添加一条记录
                    sqlSession.insert("AddInfo.addInfo",message);
                    sqlSession.insert("Command.addCommand",command);
                    sqlSession.insert("CommandContent.addCommandContent",commandContent);
                    sqlSession.commit();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
