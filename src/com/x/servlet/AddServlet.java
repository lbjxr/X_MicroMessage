package com.x.servlet;

import com.x.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x on 2017/5/3.
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接页面传值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        MaintainService maintainService = new MaintainService();
        maintainService.addInfo(command,description,content);
        //向页面跳转
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
