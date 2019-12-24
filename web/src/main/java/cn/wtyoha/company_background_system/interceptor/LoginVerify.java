package cn.wtyoha.company_background_system.interceptor;

import cn.wtyoha.company_background_system.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginVerify extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.getRequestDispatcher("/user/loginPage").forward(request, response);
            return false;
        }
        return true;
    }
}
