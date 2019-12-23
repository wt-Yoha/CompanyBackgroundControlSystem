package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.PermissionDao;
import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionServiceImpl")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> showPermissionList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return permissionDao.findAllPermission();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public void deleteList(String[] ids) {
        for (String id : ids) {
            permissionDao.deletePermission(id);
        }
    }

    @Override
    public Permission findById(String permId) {
        return permissionDao.findById(permId);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAllPermission();
    }
}
