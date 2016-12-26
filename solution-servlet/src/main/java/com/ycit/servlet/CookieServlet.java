package com.ycit.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xlch on 2016/12/25.
 */
public class CookieServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (req instanceof HttpServletRequest) {
            Cookie[] cookies = ((HttpServletRequest) req).getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getValue();
                    cookie.setMaxAge(10);
                    out.println("<h2>欢迎你，" + name  + "</h2>");
                }
            } else {
                out.println("<h2>请登录</h2>");
                Cookie cookie = new Cookie("name","xlch");
                cookie.setMaxAge(10);
                ((HttpServletResponse)res).addCookie(cookie);
            }
        }

    }
}
