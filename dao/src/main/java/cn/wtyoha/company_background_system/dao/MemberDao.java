package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
    @Select("select * from member where id = #{mid}")
    Member findById(String memberid);
}
