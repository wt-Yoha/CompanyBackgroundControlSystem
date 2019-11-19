package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOrderService {
    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Test
    public void findAll() {
        for (Order order : orderService.findAll()) {
            System.out.println(order);
        }
    }

}
