package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.domain.ResponseJson;
import cn.wtyoha.company_background_system.service.ProductService;
import cn.wtyoha.company_background_system.utils.ResponseUtils;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @RequestMapping("/productList")
    public String showProductList(HttpServletRequest request) throws IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("productList", products);
        return "productList";
    }

    @RequestMapping("/edit")
    public String editProduct() {
        return "productEdit";
    }

    @RequestMapping("/editSubmit")
    public String newProduct(Product product, HttpServletRequest request) {
        boolean resultFlag = true;
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            resultFlag = false;
        }
        if (resultFlag) {
            request.setAttribute("msg", "新增产品成功！");
            return "forward:productList";
        } else {
            request.setAttribute("msg", "保存出错，请检查提交数据");
            request.setAttribute("product", product);
            return "forward:productEdit";
        }
    }

    @RequestMapping("/deleteList")
    public String deleteList(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        boolean resultFlag = true;
        try {
            productService.deleteList(parameterMap.get("productNum"));
        } catch (Exception e) {
            e.printStackTrace();
            resultFlag = false;
        }
        if (resultFlag) {
            request.setAttribute("msg", "删除成功！");
        } else {
            request.setAttribute("msg", "删除失败！");
        }
        return "forward:productList";
    }

    @RequestMapping("/update")
    public void updateProducts(HttpServletRequest request) {

    }


}
