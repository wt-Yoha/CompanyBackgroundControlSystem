package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.SysLogDao;
import cn.wtyoha.company_background_system.domain.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSysLogService {

    @Autowired
    SysLogDao sysLogDao;

    @Test
    public void daoSave() throws InterruptedException {
        SysLog sysLog = new SysLog();
        sysLog.setId(UUID.randomUUID().toString().replace("-",""));
        sysLog.setMethod("[类名] .... [方法名].....");
        sysLog.setIp("127.0.0.1");
        Date s = new Date();
        sysLog.setVisitTime(s);
        Thread.sleep(1000);
        sysLog.setExecuteTime(new Date().getTime() - s.getTime());
        sysLog.setUrl("/user/showUserList");
        sysLog.setUserName("lalal");
        try {
            sysLogDao.save(sysLog);
        } catch (Exception e) {
            int x;
            e.printStackTrace();
        }
    }
}
