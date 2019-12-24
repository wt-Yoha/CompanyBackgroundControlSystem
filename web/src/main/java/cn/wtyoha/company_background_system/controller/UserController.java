package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping("/index")
    public String indexPage() {
        return "all-admin-index";
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginSubmit(String username, String password, HttpServletRequest request){
        User user = userService.verifyUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            return "all-admin-index";
        }
        return "fail";
    }

    @RequestMapping("/userList")
    public String userList(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                           @RequestParam(value = "size", defaultValue = "10") Integer pageSize,
                           HttpServletRequest request) {
        List<User> users = userService.userList(currentPage, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, pageInfo.getPages());
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("userList", pageInfo.getList());
        return "userList";
    }

    @RequestMapping("/userNew")
    public String userNewSubmit(User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setStatus(0);
        userService.saveUser(user);
        return "redirect:/user/userList";
    }

    @RequestMapping("/new")
    public String userNew() {
        return "userNew";
    }

    @RequestMapping("/availableUser")
    public String availableUser(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                @RequestParam(value = "size", defaultValue = "10") Integer pageSize,
                                @RequestParam(value = "isOpen", defaultValue = "false") Boolean isOpen,
                                HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] ids = parameterMap.get("id");
        if (isOpen) {
            userService.openUserList(ids);
        } else {
            userService.closeUserList(ids);
        }
        return "redirect:userList?currentPage="+currentPage+"&size="+pageSize;
    }

    @RequestMapping("/deleteList")
    public String deleteUserList(HttpServletRequest request) {
        String[] ids = request.getParameterMap().get("id");
        userService.deleteList(ids);
        return "redirect:/user/userList";
    }

    @RequestMapping("/userEdit")
    public String userEdit(String userId, HttpServletRequest request) {
        User user = userService.findById(userId);
        List<Role> unboundedRoles = userService.findUnboundedRoles(userId);
        request.setAttribute("user", user);
        request.setAttribute("avilableRoles", unboundedRoles);
        return "userEdit";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String roleId){
        userService.addRoleToUser(userId, roleId);
        return "redirect:/user/userEdit?userId="+userId;
    }

    @RequestMapping("/removeRole")
    public String removeRole(String userId, String roleId){
        userService.removeRole(userId, roleId);
        return "redirect:/user/userEdit?userId="+userId;
    }

    @RequestMapping("/userUpdate")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/userEdit?userId="+user.getId();
    }

    @RequestMapping("/test")
    public String test() {
        return "roleEdit";
    }
}
