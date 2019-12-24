package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.UserDao;
import cn.wtyoha.company_background_system.dao.User_RoleDao;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import cn.wtyoha.company_background_system.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    // 不使用 spring-security 实现的登录身份验证
    @Override
    public User verifyUser(String s, String password){
        User user = userDao.findByUserName(s);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        if (user!=null && bc.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUserName(s);
        List<SimpleGrantedAuthority> authorities = getAuthorities(user);
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

    @Override
    public List<User> userList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return userDao.findAllUsers();
    }

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public void openUserList(String[] ids) {
        for (String id : ids) {
            userDao.openUser(id);
        }
    }

    @Override
    public void closeUserList(String[] ids) {
        for (String id : ids) {
            userDao.closeUser(id);
        }
    }

    @Override
    public void deleteList(String[] ids) {
        for (String id : ids) {
            userDao.deleteBoundedRole(id);
            userDao.deleteUer(id);
        }
    }

    @Override
    public User findById(String userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<Role> findUnboundedRoles(String userId) {
        return userDao.findUnboundedRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String roleId) {
        userDao.addRoleToUser(userId, roleId);
    }

    @Override
    public void removeRole(String userId, String roleId) {
        userDao.removeRole(userId, roleId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByUserName(name);
    }
}
