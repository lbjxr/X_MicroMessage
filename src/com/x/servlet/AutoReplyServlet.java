package com.x.servlet;

import com.x.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by x on 2017/5/1.
 * 自动回复功能控制层
 */
public class AutoReplyServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            QueryService queryService = new QueryService();
            out.write(queryService.queryByCommand(req.getParameter("content")));
            out.flush();
            out.close();
            //向页面跳转
            req.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
        }
}
