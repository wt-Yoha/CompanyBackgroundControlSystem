package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "roleList", javaType = java.util.ArrayList.class, many = @Many(select = "cn.wtyoha.company_background_system.dao.RoleDao.findByUserId"))
    })
    User findByUserName(String userName);
}
