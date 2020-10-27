package cn.wolfcode.sso.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 登录拦截器
 * @author: yz
 * @create: 2018/11/16 11:38
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 如果是登录有关操作的，不拦截
        String path = req.getRequestURI();
        // 1. session还有效
        HttpSession session = req.getSession();
        String token = (String) session.getAttribute("token");
        if(token != null){
            // 放行
            chain.doFilter(request,response);
            return;
        }
        if (path.contains("login") || path.endsWith(".css") || path.endsWith(".js")){
            // 放行
            chain.doFilter(request,response);
            return;
        }else{
            System.out.println("path:"+path);
            if(path.endsWith("verify")){
                // 放行
                chain.doFilter(request,response);
                return;
            }else {
                resp.sendRedirect("login");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
