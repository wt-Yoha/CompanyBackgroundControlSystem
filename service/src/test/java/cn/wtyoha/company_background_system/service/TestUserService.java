package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.UserDao;
import cn.wtyoha.company_background_system.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserService {
    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void daoFindByUserName() {
        System.out.println(userDao.findByUserName("wt"));
    }

    @Test
    public void daoFindByUserId(){
        System.out.println(userDao.findByUserId("ee098dc105b511eab143087190f3bc94"));
    }

    @Test
    public void daoFindAll() {
        userDao.findAllUsers().forEach(System.out::println);
    }

    @Test
    public void daoSaveUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("fox");
        user.setEmail("fox@qq.com");
        user.setStatus(1);
        user.setPhoneNum("18723226644");
        String password = "123456";
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        String pwd = bcpe.encode(password);
        user.setPassword(pwd);

        userDao.saveUser(user);
    }

    @Test
    public void daoUpdateUser() {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        User wt = userDao.findByUserName("wt");
        wt.setPassword(bcpe.encode(wt.getPassword()));
        userDao.updateUser(wt);
    }

    @Test
    public void daoDeleteUser() {
        userDao.deleteUer(userDao.findByUserName("fox").getId());
    }


    @Test
    public void serviceFindByUserName() {
        System.out.println(userService.loadUserByUsername("wt"));
    }
}
