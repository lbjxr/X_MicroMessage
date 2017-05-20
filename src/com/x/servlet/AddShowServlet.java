package com.x.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by x on 2017/5/4.
 * 增加页面显示
 */
public class AddShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收页面传值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传值
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/jsp/back/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
