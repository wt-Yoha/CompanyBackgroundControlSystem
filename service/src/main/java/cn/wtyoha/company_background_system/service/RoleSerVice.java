package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleSerVice {
    List<Role> showRoleList(int currentPage, int pageSize);

    void saveRole(Role role);

    void deleteRoles(String[] ids);
}
