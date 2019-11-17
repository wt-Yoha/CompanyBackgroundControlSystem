package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.ProductDao;
import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void deleteProduct(String productNum) {
        productDao.deleteProduct(productNum);
    }

    @Override
    public void deleteList(String[] productNums) {
        int count = 0;
        for (String productNum : productNums) {
            count++;
            if (count == 2) {
                throw new RuntimeException("my exception");
            }
            deleteProduct(productNum);
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
