package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProductService {
    @Autowired
    ProductDao productDao;

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @Test
    public void testFindAll() {
        productService.findAll().forEach(System.out::println);
    }

    @Test
    public void testDao() {
        productDao.findAll().forEach(System.out::println);
    }

}
