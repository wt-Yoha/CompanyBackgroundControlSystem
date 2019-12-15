package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    @Qualifier("permissionServiceImpl")
    PermissionService permissionService;


    @RequestMapping("/permissionList")
    public String permissionList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                 HttpServletRequest request) {

        List<Permission> permissions = permissionService.showPermissionList(currentPage, pageSize);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, pageInfo.getPages());
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("permissionList", pageInfo.getList());
        return "permissionList";
    }

    @RequestMapping("/new")
    public String newPermissionPage(){
        return "permissionNew";
    }

    @RequestMapping("/permissionNew")
    public String newPermissionSubmit(Permission permission) {
        permission.setId(UUID.randomUUID().toString().replace("-", ""));
        permissionService.savePermission(permission);
        return "redirect:/permission/permissionList";
    }

    @RequestMapping("/deleteList")
    public String deleteList(HttpServletRequest request) {
        String[] ids = request.getParameterMap().get("id");
        permissionService.deleteList(ids);
        return "redirect:/permission/permissionList";
    }

}
