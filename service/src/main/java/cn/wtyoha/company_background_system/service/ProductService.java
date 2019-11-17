package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void saveProduct(Product product);

    void deleteProduct(String productNum);

    void deleteList(String[] productNums);

    void updateProduct(Product product);
}
