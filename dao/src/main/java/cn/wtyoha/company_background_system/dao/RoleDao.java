package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id = #{id}")
    Role findById(String id);

    @Select("select * from role where id in (select rid from user_role where uid = #{uid}) ")
    List<Role> findByUserId(String uid);
}
