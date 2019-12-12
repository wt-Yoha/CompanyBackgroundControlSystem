package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    @Select("select * from member where id = #{mid}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "travellers", many = @Many(select = "cn.wtyoha.company_background_system.dao.TravellerDao.findByMemberId"))
    })
    Member findById(String memberid);

    @Select("select * from member")
    List<Member> findAll();

    @Update("update member set name = #{name}, nickName = #{nickName}, phoneNum = #{phoneNum}, email = #{email} where id = #{id}")
    void updateMember(Member member);

    @Update("delete from member where id = #{id}")
    void deleteMember(String id);

    @Update("insert into member values(#{id}, #{name}, #{nickName}, #{phoneNum}, #{email})")
    void saveMember(Member member);
}
