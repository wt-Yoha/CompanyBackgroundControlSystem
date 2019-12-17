package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> showRoleList(int currentPage, int pageSize);

    void saveRole(Role role);

    void deleteRoles(String[] ids);

    Role findById(String roleId);

    List<Permission> findUnboundedPermissions(String roleId);

    void addPermToRole(String roleId, String permId);

    void removePerm(String roleId, String permId);

    void updateRole(Role role);
}
