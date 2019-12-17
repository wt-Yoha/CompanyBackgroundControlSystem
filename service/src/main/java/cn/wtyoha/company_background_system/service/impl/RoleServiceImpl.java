package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.RoleDao;
import cn.wtyoha.company_background_system.domain.Permission;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> showRoleList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return roleDao.findAllRoles();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public void deleteRoles(String[] ids) {
        for (String id : ids) {
            roleDao.deleteRole(id);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findUnboundedPermissions(String roleId) {
        return roleDao.findUnboundedPermissions(roleId);
    }

    @Override
    public void addPermToRole(String roleId, String permId) {
        roleDao.addPermToRole(roleId, permId);
    }

    @Override
    public void removePerm(String roleId, String permId) {
        roleDao.removePerm(roleId, permId);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }
}
