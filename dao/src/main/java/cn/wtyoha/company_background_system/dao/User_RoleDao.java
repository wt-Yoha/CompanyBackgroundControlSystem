package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.User_Role;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface User_RoleDao {

    @Update("insert into user_role values(#{uid}, #{rid})")
    void saveUser_Role(User_Role user_role);

    @Update("delete from user_role where uid = #{uid} and rid = #{rid}")
    void deleteUser_Role(User_Role user_role);
}
