package com.ycit.servlet;

import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by xlch on 2016/12/18.
 */
public class HelloWorldServlet extends GenericServlet {

//    private static final Logger logger = LogManager.getLogger(HelloWorldServlet.class);
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.debug("helloWorldServlet init run ===========");
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("helloWorldServlet service run..");
//        System.out.println("ServletRequest-----------------begin..");
        logger.debug("helloWorldServlet service run ===========");
        res.setCharacterEncoding("UTF-8");//要在 getWriter 之前 设置才有效
        res.setContentType("text/html");
        System.out.println("Locale======" + req.getLocale());
        System.out.println("ContentType======" + req.getContentType());
        System.out.println("CharacterEncoding======" + req.getCharacterEncoding());
        System.out.println("ContentLength======" + req.getContentLength());
        System.out.println("InputStream======" + req.getInputStream());
        System.out.println("LocalAddr======" + req.getLocalAddr());
        System.out.println("LocalName======" + req.getLocalName());
        System.out.println("LocalPort======" + req.getLocalPort());
        System.out.println("Protocol======" + req.getProtocol());
        System.out.println("RemoteHost======" + req.getRemoteHost());
        System.out.println("RemoteAddr======" + req.getRemoteAddr());
        System.out.println("ServerName======" + req.getServerName());
        System.out.println("Scheme======" + req.getScheme());
        System.out.println("ServerPort======" + req.getServerPort());
        System.out.println("ServletRequest-----------------end..");
        System.out.println("ServletResponse-----------------begin..");
        System.out.println( "CharacterEncoding======" + res.getCharacterEncoding());
        System.out.println("BufferSize======" + res.getBufferSize());
        System.out.println( "ContentType======" + res.getContentType());
        System.out.println("Locale======" +  res.getLocale());
        System.out.println("ServletResponse-----------------begin..");
        PrintWriter out = res.getWriter();
        out.println("<h2> hello world</h2>");
        out.println("<h2> 你好，世界</h2>");
        res.setContentType("multipart/form-data");
    }

    @Override
    public void destroy() {
        logger.debug("helloWorldServlet destroy run ===========");
    }
}
