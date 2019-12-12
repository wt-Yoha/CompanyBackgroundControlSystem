package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.PermissionDao;
import cn.wtyoha.company_background_system.dao.RoleDao;
import cn.wtyoha.company_background_system.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPermissionService {
    @Autowired
    PermissionDao permissionDao;

    @Test
    public void daoSavePermission() {
        Permission p = new Permission();
        p.setId(UUID.randomUUID().toString().replace("-", ""));
        p.setPermissionName("user.save");
        p.setUrl("/user/save");
        permissionDao.savePermission(p);
    }

    @Test
    public void daoFindAll() {
        permissionDao.findAllPermission().forEach(System.out::println);
    }

    @Test
    public void daoFindById() {
        System.out.println(permissionDao.findById("6b0d4d4911c842098690d1b6b63de59c"));
    }

    @Test
    public void daoDelete() {
        permissionDao.deletePermission("6e09e173a70c4cf0bca6d4857eaf1e34");
    }

    @Test
    public void daoUpdate() {
        Permission p = permissionDao.findById("6b0d4d4911c842098690d1b6b63de59c");
        p.setUrl("/user/findAll");
        permissionDao.updatePermission(p);
    }

}
