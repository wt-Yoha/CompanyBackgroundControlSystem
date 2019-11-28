package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.Product;
import cn.wtyoha.company_background_system.domain.Traveller;
import cn.wtyoha.company_background_system.service.MemberService;
import cn.wtyoha.company_background_system.service.OrderService;
import cn.wtyoha.company_background_system.service.ProductService;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import org.apache.ibatis.annotations.ResultMap;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Autowired
    @Qualifier("productServiceImpl")
    ProductService productService;

    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    @RequestMapping("/orderList")
    public String showOrderList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                @RequestParam(value = "size", defaultValue = "5") int pageSize,
                                HttpServletRequest request) {

        List<Order> orders = orderService.findAll(currentPage, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        int startPageNo = currentPage - 5 > 0 ? currentPage - 5 : 1;
        int endPageNo = Math.min(10 - startPageNo, pageInfo.getPages());
        request.setAttribute("startPageNo", startPageNo);
        request.setAttribute("endPageNo", endPageNo);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("orderList", pageInfo.getList());
        return "orderList";
    }

    @RequestMapping("/showOrderDetailsById")
    public String showOrderDetailsById(@RequestParam(value = "edit", defaultValue = "false") boolean edit, String id, HttpServletRequest request) {
        Order order = orderService.findById(id);
        request.setAttribute("order", order);
        if (edit) {
            List<Product> productList = productService.findAll();
            request.setAttribute("productList", productList);
            // 该会员其他订单的旅客表
            request.setAttribute("linkedTravellers", order.getMember().getTravellers());
            return "orderEdit";
        }
        return "orderDetail";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(Order order, HttpServletRequest request) {
        // 更新内容：订单编号，下单时间，订单描述，绑定的 product
        orderService.updateOrderBase(order);
        System.out.println("forward:showOrderDetailsById?id="+order.getId()+"&edit=true");
        return "redirect:showOrderDetailsById?id="+order.getId()+"&edit=true";
    }


}
