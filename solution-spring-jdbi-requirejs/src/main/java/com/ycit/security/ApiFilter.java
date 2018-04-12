package com.ycit.security;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * api 拦截器
 *
 * @author xlch
 * @Date 2017-12-27 14:36
 */
public class ApiFilter extends UserFilter {

    private static final String ERROR_JSON = "{\"code\":401,\"url\":\"%s\"}";

    public boolean onAccessDenied(ServletRequest request, ServletResponse response)throws IOException {
        if (response instanceof HttpServletResponse && request instanceof HttpServletRequest) {
            HttpServletResponse resp = WebUtils.toHttp(response);
            HttpServletRequest req = WebUtils.toHttp(request);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().printf(ERROR_JSON, req.getRequestURI());
            return false;
        }
        return false;
    }
}
