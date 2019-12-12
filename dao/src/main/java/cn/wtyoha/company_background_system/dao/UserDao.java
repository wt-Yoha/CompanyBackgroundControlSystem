package cn.wtyoha.company_background_system.dao;

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
}
