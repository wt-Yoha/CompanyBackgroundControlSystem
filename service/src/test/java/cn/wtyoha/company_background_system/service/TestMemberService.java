package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.MemberDao;
import cn.wtyoha.company_background_system.domain.Member;
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

    @Test
    public void daoUpdate() {
        Member member = memberDao.findById("52b783a905b311eab143087190f3bc94");
        member.setNickName("YongQiang");
        memberDao.updateMember(member);
    }

    @Test
    public void daoSave() {
        Member member = memberDao.findById("52b783a905b311eab143087190f3bc94");
        member.setName("楚云飞");
        member.setNickName("cyf888");
        member.setPhoneNum("15828237564");
        member.setEmail("cyf@163.com");
        memberDao.saveMember(member);
    }

    @Test
    public void daoDelete() {
        memberDao.deleteMember("f998bbba0c3211eaa50f087190f3bc94");
    }
}
