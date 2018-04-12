package com.ycit.filter;

import com.ycit.servlet.HelloWorldServlet;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xlch on 2016/12/22.
 */
public class HelloWorldFilter implements Filter {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("HelloWorldFilter init run ===========");
        System.out.println("HelloWorldFilter init run ===========");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("HelloWorldFilter doFilter  before run ===========");
        System.out.println("HelloWorldFilter doFilter  before run ===========");
        PrintWriter out = response.getWriter();
        out.println("<h2> filter hello world !</h2>");
        chain.doFilter(request,response);
        logger.debug("HelloWorldFilter doFilter  after run ===========");
        System.out.println("HelloWorldFilter doFilter  after run ===========");
    }

    public void destroy() {
        logger.debug("HelloWorldFilter destroy run ===========");
        System.out.println("HelloWorldFilter destroy run ===========");
    }
}
