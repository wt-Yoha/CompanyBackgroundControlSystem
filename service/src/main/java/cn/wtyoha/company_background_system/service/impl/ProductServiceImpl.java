package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.ProductDao;
import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            productDao.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
