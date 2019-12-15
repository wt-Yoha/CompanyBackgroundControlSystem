package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.RoleSerVice;
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
    RoleSerVice roleSerVice;


    @RequestMapping("/roleList")
    public String roleList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                           HttpServletRequest request) {
        List<Role> roles = roleSerVice.showRoleList(currentPage, pageSize);
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
        roleSerVice.saveRole(role);
        return "redirect:roleList";
    }

    @RequestMapping("/deleteList")
    public String deleteList(HttpServletRequest request) {
        String[] ids = request.getParameterMap().get("id");
        roleSerVice.deleteRoles(ids);
        return "redirect:roleList";
    }
}
