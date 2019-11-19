package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.TravellerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTravellerService {
    @Autowired
    TravellerDao travellerDao;

    @Test
    public void daoFindByOrderId() {
        System.out.println(travellerDao.findByOrderId("4w5045c2105b911eab143087190f3bc94"));
    }
}
