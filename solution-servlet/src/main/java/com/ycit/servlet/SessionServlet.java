package com.ycit.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xlch on 2016/12/26.
 */
public class SessionServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset:utf-8");
        res.setCharacterEncoding("utf-8");
        PrintWriter out = res.getWriter();
        if (req instanceof HttpServletRequest) {
            HttpSession session = ((HttpServletRequest) req).getSession(true);
            String id = session.getId();
            long time = session.getCreationTime();
            boolean isNew = session.isNew();
            long accessTime = session.getLastAccessedTime();
            int maxInactive = session.getMaxInactiveInterval();
            out.println("<h2>session isNew =  " + isNew +"</h2>");
            out.println("<h2>session createTime "+ time +"</h2>");
            out.println("<h2>session id = "+ id +"</h2>");
            out.println("<h2>LastAccessedTime  = "+ accessTime +"</h2>");
            out.println("<h2>MaxInactiveInterval  = "+ maxInactive +"</h2>");
        }
    }
}
