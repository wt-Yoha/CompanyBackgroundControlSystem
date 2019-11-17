package cn.wtyoha.company_background_system.utils;

import cn.wtyoha.company_background_system.domain.ResponseJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    public static void setResponse(HttpServletResponse response, ResponseJson responseJson) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper obm = new ObjectMapper();
        obm.writeValue(response.getOutputStream(), responseJson);
    }
}
