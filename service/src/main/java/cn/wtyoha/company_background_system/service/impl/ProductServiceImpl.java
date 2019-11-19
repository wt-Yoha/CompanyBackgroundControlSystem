package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.ProductDao;
import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.service.ProductService;
import com.github.pagehelper.PageHelper;
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
    public List<Product> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
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
        for (String productNum : productNums) {
            deleteProduct(productNum);
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void availableProductList(String[] productNums, boolean available) {
        if (available) {
            for (String productNum : productNums) {
                productDao.availableProduct(productNum);
            }
        } else {
            for (String productNum : productNums) {
                productDao.disAvailableProduct(productNum);
            }
        }
    }
}
