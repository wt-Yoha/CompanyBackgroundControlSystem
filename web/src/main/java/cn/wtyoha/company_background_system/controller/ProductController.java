package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @RequestMapping("/productList")
    public String showProductList(HttpServletRequest request) {
        List<Product> products = productService.findAll();
        request.setAttribute("productList", products);
        return "all-order-manage-list";
    }


}
