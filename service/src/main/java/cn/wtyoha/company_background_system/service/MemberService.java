package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Member;

import java.util.List;

public interface MemberService {
    Member findById(String memberId);

    void updateMember(Member member);

    List<Member> findAll();

    void saveMember(Member member);
}
