package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> userList(int currentPage, int pageSize);

    void saveUser(User user);
}
