package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.UserDao;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUserName(s);
        List<SimpleGrantedAuthority> authorities = getAuthorities(user);
        System.out.println(user);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getStatus() != 0, true, true, true,
                authorities);
    }

    List<SimpleGrantedAuthority> getAuthorities(User user){
        List<SimpleGrantedAuthority> result = new ArrayList<>();
        for (Role role : user.getRoleList()) {
            result.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return result;
    }
}