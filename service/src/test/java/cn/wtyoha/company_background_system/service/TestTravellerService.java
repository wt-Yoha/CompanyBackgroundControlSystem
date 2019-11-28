package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.TravellerDao;
import cn.wtyoha.company_background_system.domain.Traveller;
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

    @Test
    public void daoSaveTraveller() {
        Traveller traveller = new Traveller();
        traveller.setName("德邦总管");
        traveller.setPhoneNum("15823428934");
        traveller.setCredentialsType(0);
        traveller.setCredentialsNum("878173284723467234824");
        traveller.setSex("男");
        travellerDao.saveTraveller(traveller);
    }

    @Test
    public void daoDeleteTraveller() {
        travellerDao.deleteTraveller("183df7ec0c0f11ea986f087190f3bc94");
    }

    @Test
    public void daoFindAll() {
        travellerDao.findAll().forEach(System.out::println);
    }

    @Test
    public void daoUpdateTraveller() {
        Traveller traveller = travellerDao.findById("52b781f005b311eab143087190f3bc94");
        traveller.setTravellerType(0);
        travellerDao.updateTraveller(traveller);
    }
}
