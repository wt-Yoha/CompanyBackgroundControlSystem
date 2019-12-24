package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> userList(int currentPage, int pageSize);

    void saveUser(User user);

    void openUserList(String[] ids);

    void closeUserList(String[] ids);

    void deleteList(String[] ids);

    User findById(String userId);

    List<Role> findUnboundedRoles(String userId);

    void addRoleToUser(String userId, String roleId);

    void removeRole(String userId, String roleId);

    void updateUser(User user);

    User findByName(String name);

    User verifyUser(String username, String password);
}
