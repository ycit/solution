package com.ycit.servlet;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xlch on 2016/12/18.
 */
public class HiServlet extends GenericServlet {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.debug("HiServlet init run==========");
    }


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.debug("HiServlet service run==========");
        res.setCharacterEncoding("UTF-8");
//        String name = getServletConfig().getInitParameter("name"); //获取 servlet 配置信息
//        String names = getServletContext().getInitParameter("name");// 获取整个应用 配置信息 context-param
        res.setContentType("text/html;charset:UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<h2>hi world </h2>");
//        out.println("<h2> hi " + name +" </h2>");
        out.println("<h2> hi 小明 </h2>");

    }

    @Override
    public void destroy() {
        logger.debug("HiServlet destroy run==========");
    }
}
