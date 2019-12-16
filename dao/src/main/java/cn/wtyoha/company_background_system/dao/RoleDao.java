package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id = #{id}")
    @Results(id = "permissionListMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "permissionList", javaType = ArrayList.class, many = @Many(select = "cn.wtyoha.company_background_system.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id);

    @Select("select * from role")
    List<Role> findAllRoles();

    @Update("insert into role values(#{id}, #{roleName}, #{roleDesc})")
    void saveRole(Role role);

    @Update("update role set roleName = #{roleName}, roleDesc = #{roleDesc} where id = #{id}")
    void updateRole(Role role);

    @Update("delete from role where id = #{id}")
    void deleteRole(String id);

    @Select("select * from role where id in (select rid from user_role where uid = #{uid}) ")
    @ResultMap("permissionListMap")
    List<Role> findByUserId(String uid);

    @Select("select * from role where id in (select rid from role_permission where pid = #{pid})")
    List<Role> findByPermissionId(String pid);
}
