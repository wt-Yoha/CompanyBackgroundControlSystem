package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Product;

import javax.swing.plaf.ProgressBarUI;
import java.util.List;

public interface ProductService {
    List<Product> findAll(int currentPage, int pageSize);

    List<Product> findAll();

    void saveProduct(Product product);

    void deleteProduct(String productNum);

    void deleteList(String[] productNums);

    void updateProduct(Product product);

    void availableProductList(String[] productNums, boolean available);

    Product findById(String id);
}
