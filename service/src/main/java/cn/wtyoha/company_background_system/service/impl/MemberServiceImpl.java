package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.MemberDao;
import cn.wtyoha.company_background_system.domain.Member;
import cn.wtyoha.company_background_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;

    @Override
    public Member findById(String memberId) {
        return memberDao.findById(memberId);
    }

    @Override
    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public void saveMember(Member member) {
        memberDao.saveMember(member);
    }
}
