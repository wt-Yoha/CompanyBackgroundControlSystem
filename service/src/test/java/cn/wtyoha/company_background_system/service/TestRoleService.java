package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.RoleDao;
import cn.wtyoha.company_background_system.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRoleService {
    @Autowired
    RoleDao roleDao;

    @Test
    public void daoFindAll() {
        roleDao.findAllRoles().forEach(System.out::println);
    }

    @Test
    public void daoFindById() {
        System.out.println(roleDao.findById("64cfc7c61afe11eaac67a096108d9233"));
    }

    @Test
    public void daoSave() {
        Role role = new Role();
        role.setId(UUID.randomUUID().toString().replace("-", ""));
        role.setRoleName("traveller");
        roleDao.saveRole(role);
    }

    @Test
    public void daoUpdate() {
        Role role = roleDao.findById("c359bddf8a1642e48d7710de7aea0d56");
        role.setRoleName("ROLE_TRAVELLER");
        roleDao.updateRole(role);
    }

    @Test
    public void daoDelete() {
        roleDao.deleteRole("d9f6008ca02549daa878930fa6921c1f");
    }

}
