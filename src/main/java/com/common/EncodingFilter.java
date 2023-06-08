package com.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        if("POST".equals(hrequest.getMethod())){
            request.setCharacterEncoding(encodingType);
            response.setContentType("text/html; charset=UTF-8");
            System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding() + "/" + response.getContentType());
        }
        if("GET".equals(hrequest.getMethod())){
            request.setCharacterEncoding(encodingType);
            response.setContentType("text/html; charset=UTF-8");
            System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding() + "/" + response.getContentType());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
