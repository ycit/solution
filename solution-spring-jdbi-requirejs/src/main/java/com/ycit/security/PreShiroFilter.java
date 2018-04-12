package com.ycit.security;

import javax.servlet.*;
import java.io.IOException;

/**
 * shiro filter 前置过滤器
 *
 * @author xlch
 * @Date 2017-12-27 16:10
 */
public class PreShiroFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RegisterInfoInvoke infoInvoke = new RegisterInfoInvoke();
        infoInvoke.register();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
