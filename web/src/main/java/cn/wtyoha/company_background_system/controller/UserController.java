package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.UserService;
import com.github.pagehelper.PageInfo;
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

    @RequestMapping("/userList")
    public String userList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                           @RequestParam(value = "size", defaultValue = "10") int pageSize,
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
    public String availableUser(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                @RequestParam(value = "size", defaultValue = "10") int pageSize,
                                @RequestParam(value = "isOpen", defaultValue = "false") boolean isOpen,
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
}
