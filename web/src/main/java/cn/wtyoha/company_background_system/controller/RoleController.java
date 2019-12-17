package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    @Qualifier("roleServiceImpl")
    RoleService roleService;


    @RequestMapping("/roleList")
    public String roleList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           HttpServletRequest request) {
        List<Role> roles = roleService.showRoleList(currentPage, pageSize);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, pageInfo.getPages());
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("roleList", pageInfo.getList());
        return "roleList";
    }

    @RequestMapping("/new")
    public String newPageRole(){
        return "roleNew";
    }

    @RequestMapping("/roleNew")
    public String newRoleSubmit(Role role){
        role.setId(UUID.randomUUID().toString().replace("-", ""));
        roleService.saveRole(role);
        return "redirect:roleList";
    }

    @RequestMapping("/deleteList")
    public String deleteList(HttpServletRequest request) {
        String[] ids = request.getParameterMap().get("id");
        roleService.deleteRoles(ids);
        return "redirect:roleList";
    }

    @RequestMapping("/roleEdit")
    public String roleEdit(String roleId, HttpServletRequest request){
        Role role = roleService.findById(roleId);
        List<Permission> unboundedPerm = roleService.findUnboundedPermissions(roleId);
        request.setAttribute("role", role);
        request.setAttribute("avilablePerm", unboundedPerm);
        return "roleEdit";
    }

    @RequestMapping("/addPermToRole")
    public String addPermToRole(String roleId, String permId){
        roleService.addPermToRole(roleId, permId);
        return "redirect:/role/roleEdit?roleId="+roleId;
    }

    @RequestMapping("/removePerm")
    public String removePerm(String roleId, String permId){
        roleService.removePerm(roleId, permId);
        return "redirect:/role/roleEdit?roleId="+roleId;
    }

    @RequestMapping("/roleUpdate")
    public String roleUpdate(Role role){
        roleService.updateRole(role);
        return "redirect:/role/roleEdit?roleId="+role.getId();
    }

}
