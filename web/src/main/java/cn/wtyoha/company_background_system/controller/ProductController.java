package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.domain.ResponseJson;
import cn.wtyoha.company_background_system.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        return "productList";
    }

    @RequestMapping("/edit")
    public String editProduct() {
        return "productEdit";
    }

    @RequestMapping("/editSubmit")
    public void newProduct(Product product,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean resultFlag = productService.saveProduct(product);
        if(resultFlag)
            request.getRequestDispatcher("/product/productList").forward(request, response);
        else{
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            ObjectMapper obm = new ObjectMapper();
            ResponseJson responseJson = new ResponseJson();
            responseJson.setError(true);
            responseJson.setErrorMsg("保存出错，请检查提交数据");
            obm.writeValue(response.getOutputStream(), responseJson);
        }
    }

}
