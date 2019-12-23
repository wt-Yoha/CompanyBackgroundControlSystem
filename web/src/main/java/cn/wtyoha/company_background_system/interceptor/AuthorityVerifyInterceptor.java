package cn.wtyoha.company_background_system.interceptor;

import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.PermissionService;
import cn.wtyoha.company_background_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@Component
public class AuthorityVerifyInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    @Qualifier("permissionServiceImpl")
    PermissionService permissionService;

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    Set<String> updatePermissionUrlList = null;
    Set<Permission> checkedResources = null;
    Set<Permission> privileges = null;
    long time = -1;

    void initCheckedResources(HttpServletRequest request){
        checkedResources = new HashSet<>();
        List<Permission> all = permissionService.findAll();
        for (Permission permission : all) {
            permission.setUrl(request.getContextPath()+permission.getUrl());
        }
        checkedResources.addAll(all);
    }

    void getUserPrivileges(HttpServletRequest request){
        User loginUser = userService.findByName(request.getUserPrincipal().getName());
        privileges = new HashSet<>();
        for (Role role : loginUser.getRoleList()) {
            for (Permission permission : role.getPermissionList()) {
                permission.setUrl(request.getContextPath()+permission.getUrl());
            }
            privileges.addAll(role.getPermissionList());
        }
    }

    void setUpdatePermissionUrlList(HttpServletRequest request) {
        InputStream in = AuthorityVerifyInterceptor.class.getClassLoader().getResourceAsStream("updatePermissionUrl.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        updatePermissionUrlList = new HashSet<>();
        while (true){
            try {
                if (!br.ready()) break;
                updatePermissionUrlList.add(request.getContextPath()+br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    boolean permissionChanged(HttpServletRequest request){
        if (updatePermissionUrlList == null) {
            setUpdatePermissionUrlList(request);
        }
        boolean result;
        Object flag = request.getSession().getAttribute("isPermissionChanged");
        if (flag!=null && (Boolean)flag) {
            request.getSession().setAttribute("isPermissionChanged", false);
            initCheckedResources(request);
            result = true;
        } else {
            result = false;
        }
        String url = request.getRequestURI();
        if (updatePermissionUrlList.contains(url)) {
            request.getSession().setAttribute("isPermissionChanged", true);
        }
        return result;
    }

    // 定义每隔一段时间更新该用户权限情况
    private boolean timeOut(HttpServletRequest request) {
        Date date = new Date();
        long now = date.getTime();
        Object lastTime = request.getSession().getAttribute("lastTime");
        if (lastTime == null) {
            request.getSession().setAttribute("lastTime", now);
            return true;
        }
        long deltaMin = (now - (long) lastTime)/(1000 * 60);
        // 超过三十分钟也更新
        return deltaMin > 30;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (checkedResources == null) {
            initCheckedResources(request);
        }
        if (privileges == null || permissionChanged(request) || timeOut(request)) {
            getUserPrivileges(request);
        }
        Permission aimOperation = new Permission();
        String url = request.getRequestURI();
        aimOperation.setUrl(url);
        if (checkedResources.contains(aimOperation)) {
            // 访问资源是需要权限的
            if (privileges.contains(aimOperation)) {
                // 用户拥有该权限
                return true;
            } else {
                // 该用户没有权限 跳转错误页面
                request.getRequestDispatcher("/authorityError").forward(request, response);
                return false;
            }
        }
        // 访问资源不需要权限直接放行
        return true;
    }
}
