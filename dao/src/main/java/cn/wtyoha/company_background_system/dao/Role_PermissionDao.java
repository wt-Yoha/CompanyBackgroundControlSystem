package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Role_Permission;
import cn.wtyoha.company_background_system.domain.User_Role;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_PermissionDao {
    @Update("insert into role_permission values(#{rid}, #{pid})")
    void saveUser_Role(Role_Permission role_permission);

    @Update("delete from role_permission where rid = #{rid} and pid = #{pid}")
    void deleteUser_Role(Role_Permission role_permission);
}
