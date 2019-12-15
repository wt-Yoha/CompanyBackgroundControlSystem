package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.RoleDao;
import cn.wtyoha.company_background_system.domain.Role;
import cn.wtyoha.company_background_system.service.RoleSerVice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleSerVice {
    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> showRoleList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return roleDao.findAllRoles();
    }
}
