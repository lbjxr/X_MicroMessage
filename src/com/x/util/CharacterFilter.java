package com.x.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by x on 2017/5/2.
 * 页面编码转换
 */
public class CharacterFilter implements Filter {

    String ecode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ecode = filterConfig.getInitParameter("Character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding(ecode);
        servletResponse.setCharacterEncoding(ecode);
        servletResponse.setContentType("text/html;charser="+ecode);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
