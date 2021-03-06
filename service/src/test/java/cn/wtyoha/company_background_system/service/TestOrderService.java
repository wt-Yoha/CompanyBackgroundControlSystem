package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.domain.Member;
import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.domain.Traveller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOrderService {
    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Test
    public void serviceFindAll() {
        for (Order order : orderService.findAll(1, 5)) {
            System.out.println(order);
        }
    }

    @Test
    public void saveOrder() {
        Order order = new Order();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        order.setId(uuid);
        order.setOrderTime(new Date());
        order.setOrderNum("6666666666");
        order.setOrderDesc("");
        order.setOrderStatus(0);

        Member member = new Member();
        member.setId("e799f46b00c841a59358b271d4ed889f");

        Product product = new Product();
        product.setId("b5ba5ab3094211ea8756000ec657fad1");

        order.setMember(member);
        order.setProduct(product);

        orderService.saveOrder(order);
    }

    @Test
    public void daoFindAll2() {
        orderDao.findALL2().forEach(System.out::println);
    }

    @Test
    public void daoSave() {
        Random random = new Random();
        Order order = new Order();
        order.setOrderNum(String.valueOf(random.nextInt(99999999)));
        order.setPeopleCount(2);
        order.setOrderStatus(1);
        order.setOrderTime(new Date());
        order.setPayType(0);
        Member member = new Member();
        member.setId("52b7838305b311eab143087190f3bc94");
        Product product = new Product();
        product.setId("b5ba5ab3094211ea8756000ec657fad1");
        order.setMember(member);
        order.setProduct(product);
        orderDao.saveOrder(order);
    }

    @Test
    public void daoUpdate() {
        Order order = new Order();
        order.setId("ef9589bf0a7b11ea8fc4087190f3bc94");
        order.setOrderNum("18022190");
        order.setPeopleCount(2);
        order.setOrderStatus(0);
        order.setOrderTime(new Date());
        order.setPayType(0);
        Member member = new Member();
        member.setId("52b7838305b311eab143087190f3bc94");
        Product product = new Product();
        product.setId("b5ba5ab3094211ea8756000ec657fad1");
        order.setMember(member);
        order.setProduct(product);
        orderDao.updateOrder(order);
    }

    @Test
    public void daoDelete() {
        orderDao.deleteOrder("ef9589bf0a7b11ea8fc4087190f3bc94");
    }

    @Test
    public void daoFindById() {
        System.out.println(orderDao.findById("45045c2105b911eab143087190f3bc94"));
    }

}
