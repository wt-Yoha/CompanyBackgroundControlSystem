package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Member;

public interface MemberService {
    Member findById(String memberId);

    void updateMember(Member member);
}
