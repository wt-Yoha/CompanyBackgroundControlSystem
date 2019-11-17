package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.dao.ProductDao;
import cn.wtyoha.company_background_system.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;

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
    public void saveProduct() throws ParseException {
        Product product = new Product();
        product.setProductNum("3432432");
        product.setProductName("哈尔滨-漠河7七日游");
        product.setCityName("上海");
        product.setDepartureTimeStr("2019-11-22");
        product.setProductPrice(2400.0);
        product.setProductStatusStr("开启");
        product.setProductDesc("一场冬日的暖阳之旅");
        productService.saveProduct(product);
    }

    @Test
    public void deleteProduct() {
        productService.deleteProduct("3432432");
        testFindAll();
    }

    @Test
    public void updateProduct() throws ParseException {
        Product product = new Product();
        product.setProductNum("3432432");
        product.setProductName("哈尔滨-漠河9日游");
        product.setCityName("北京");
        product.setDepartureTimeStr("2019-11-22");
        product.setProductPrice(2440.0);
        product.setProductStatusStr("关闭");
        product.setProductDesc("冰天雪地");
        productService.updateProduct(product);
        testFindAll();
    }

    @Test
    public void testDao() {
        productDao.findAll().forEach(System.out::println);
    }

}
