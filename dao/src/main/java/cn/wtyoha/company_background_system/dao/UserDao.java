package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from user where username = #{username}")
    @Results(id = "rolesMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "roleList", javaType = java.util.ArrayList.class, many = @Many(select = "cn.wtyoha.company_background_system.dao.RoleDao.findByUserId"))
    })
    User findByUserName(String userName);

    @Select("select * from user where id = #{id}")
    @ResultMap("rolesMap")
    User findByUserId(String id);

    @Select("select * from user")
    List<User> findAllUsers();

    @Select("insert into user values(#{id}, #{userName}, #{email}, #{password}, #{phoneNum}, #{status})")
    void saveUser(User user);

    @Update("update user set userName = #{userName}, email =  #{email}, password =  #{password}, phoneNum =  #{phoneNum}, status = #{status} where id = #{id}")
    void updateUser(User user);

    @Update("delete from user where id = #{id}")
    void deleteUer(String id);

    @Update("update user set status = 1 where id = #{id}")
    void openUser(String id);

    @Update("update user set status = 0 where id = #{id}")
    void closeUser(String id);

    @Select("select * from role where id not in (select rid from user_role where uid = #{id})")
    List<Role> findUnboundedRoles(String userId);

    @Update("insert into user_role values(#{rid}, #{uid})")
    void addRoleToUser(@Param("uid") String userId, @Param("rid") String roleId);

    @Update("delete from user_role where uid=#{uid} and rid=#{rid}")
    void removeRole(@Param("uid") String userId,@Param("rid") String roleId);

    @Update("delete from user_role where uid = #{uid}")
    void deleteBoundedRole(String uid);
}
