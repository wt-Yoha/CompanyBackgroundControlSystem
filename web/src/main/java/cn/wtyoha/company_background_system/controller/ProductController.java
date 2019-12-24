package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.domain.ResponseJson;
import cn.wtyoha.company_background_system.service.ProductService;
import cn.wtyoha.company_background_system.utils.ResponseUtils;
import com.github.pagehelper.PageInfo;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showProductList(@RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(name = "size", defaultValue = "10") Integer pageSize, HttpServletRequest request) throws IOException {
        List<Product> products = productService.findAll(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(products);
        int totalPage = pageInfo.getPages();
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, totalPage);
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("productList", pageInfo.getList());
        return "productList";
    }

    // 编辑修改产品页面
    @RequestMapping("/edit")
    public String editProduct(Product product, HttpServletRequest request) {
        request.setAttribute("product", product);
        return "productEdit";
    }

    // 新建产品页面
    @RequestMapping("/new")
    public String newProduct(Product product, HttpServletRequest request) {
        request.setAttribute("product", product);
        return "productNew";
    }

    @RequestMapping("/editSubmit")
    public String editSubmitProduct(Product product, HttpServletRequest request) {
        boolean resultFlag = true;
        try {
            productService.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            resultFlag = false;
        }
        if (resultFlag) {
            request.setAttribute("msg", "修改产品成功！");
            return "forward:productList";
        } else {
            request.setAttribute("msg", "保存出错，请检查提交数据");
            request.setAttribute("product", product);
            return "forward:productEdit";
        }
    }

    @RequestMapping("/newSubmit")
    public String newSubmitProduct(Product product, HttpServletRequest request) {
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
    public String deleteList(HttpServletRequest request) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        boolean resultFlag = true;
        try {
            productService.deleteList(parameterMap.get("productNum"));
        } catch (Exception e) {
            e.printStackTrace();
            resultFlag = false;
            throw new Exception(e);
        }
        if (resultFlag) {
            request.setAttribute("msg", "删除成功！");
        } else {
            request.setAttribute("msg", "删除失败！");
        }
        return "forward:productList";
    }

    @RequestMapping("/availableProduct")
    public String updateProducts(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String isOpen = request.getParameter("isOpen");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("size");
        boolean resultFlag = true;
        try {
            if ("true".equals(isOpen)) {
                productService.availableProductList(parameterMap.get("productNum"), true);
            } else {
                productService.availableProductList(parameterMap.get("productNum"), false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultFlag = false;
        }
        if (resultFlag) {
            request.setAttribute("msg", "更新成功！");
        } else {
            request.setAttribute("msg", "更新失败！");
        }
        return "forward:productList?currentPage="+currentPage+"&size="+pageSize;
    }


}
