package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from permission")
    List<Permission> findAllPermission();

    @Select("select * from permission where id = #{id}")
    @Results(id = "rolesMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "roleList", javaType = ArrayList.class, many = @Many(select = "cn.wtyoha.company_background_system.dao.RoleDao.findByPermissionId"))
    })
    Permission findById(String id);

    @Update("insert into permission values(#{id}, #{permissionName}, #{url})")
    void savePermission(Permission p);

    @Update("update permission set permissionName = #{permissionName}, url = #{url} where id = #{id}")
    void updatePermission(Permission p);

    @Update("delete from permission where id = #{id}")
    void deletePermission(String id);

    @Select("select * from permission where id in (select pid from role_permission where rid = #{rid})")
    List<Permission> findByRoleId(String rid);
}
