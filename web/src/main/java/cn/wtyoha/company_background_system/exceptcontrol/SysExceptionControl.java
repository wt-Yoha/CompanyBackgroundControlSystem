package cn.wtyoha.company_background_system.exceptcontrol;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("handlerExceptionResolver")
public class SysExceptionControl implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();

        Throwable cause = e.getCause();
        String errorMessage = cause.getMessage();

        ModelAndView mv = new ModelAndView();
        mv.getModel().put("errorMsg", errorMessage);
        mv.setViewName("generalError");
        return mv;
    }
}
