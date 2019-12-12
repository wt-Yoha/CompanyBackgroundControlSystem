package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void serviceFindByUserName() {
        System.out.println(userService.loadUserByUsername("wt"));
    }
}
