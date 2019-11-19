package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.MemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMemberService {
    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberServiece;

    @Autowired
    MemberDao memberDao;

    @Test
    public void findById() {
        System.out.println(memberServiece.findById("52b781f005b311eab143087190f3bc94"));
    }

}
