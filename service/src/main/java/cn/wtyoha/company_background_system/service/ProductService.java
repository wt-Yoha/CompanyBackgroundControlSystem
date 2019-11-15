package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    boolean saveProduct(Product product);

}
