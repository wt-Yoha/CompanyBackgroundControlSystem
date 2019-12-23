package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> showPermissionList(int currentPage, int pageSize);

    void savePermission(Permission permission);

    void deleteList(String[] ids);

    Permission findById(String permId);

    void updatePermission(Permission permission);

    List<Permission> findAll();
}
