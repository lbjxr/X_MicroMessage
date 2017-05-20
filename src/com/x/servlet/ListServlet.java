package com.x.servlet;

import com.x.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x on 2017/5/1.
 * 列表页面初始化配置
 */
public class ListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传值
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        //实例化ListService对象\\
        QueryService queryService = new QueryService();
        //查询消息列表并传给页面
        req.setAttribute("messageList",queryService.queryMessageList(command,description));
        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/back.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
