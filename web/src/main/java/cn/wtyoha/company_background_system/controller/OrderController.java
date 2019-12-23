package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.domain.Member;
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
import java.util.*;

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
    public String showOrderList(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                @RequestParam(value = "size", defaultValue = "10") Integer pageSize,
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
    public String showOrderDetailsById(@RequestParam(value = "edit", defaultValue = "false") Boolean edit, String id, HttpServletRequest request) {
        Order order = orderService.findById(id);
        request.setAttribute("order", order);
        if (edit) {
            List<Product> productList = productService.findAll();
            request.setAttribute("productList", productList);
            // 该会员其他订单的旅客表
            Set membersTravellers = new HashSet(Arrays.asList(order.getMember().getTravellers()));
            Set ordersTravellers = new HashSet(order.getTravellers());
            membersTravellers.removeAll(ordersTravellers);
            request.setAttribute("linkedTravellers", membersTravellers);
            return "orderEdit";
        }
        return "orderDetail";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(Order order, HttpServletRequest request) {
        // 更新内容：订单编号，下单时间，订单描述，绑定的 product
        orderService.updateOrderBase(order);
        System.out.println("forward:showOrderDetailsById?id=" + order.getId() + "&edit=true");
        return "redirect:showOrderDetailsById?id=" + order.getId() + "&edit=true";
    }


    @RequestMapping("/orderNew")
    public String newOrder(Order order, HttpServletRequest request) {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        List<Member> members = memberService.findAll();
        request.setAttribute("members", members);

        Product bindProduct = null;
        Member bindMember = null;

        if (order.getProduct() != null) {
            bindProduct = productService.findById(order.getProduct().getId());
            order.setProduct(bindProduct);
        }
        if (order.getMember() != null) {
            bindMember = memberService.findById(order.getMember().getId());
            order.setMember(bindMember);
        }

        request.setAttribute("order", order);
        return "orderNew";
    }

    @RequestMapping("/newOrderSubmit")
    public String newOrderSubmit(Order order) {
        if (order.getMember() == null || (order.getProduct() == null && order.getProduct().getId() == null && !"".equals(order.getProduct().getId()))) {
            return "orderNew";
        }
        Member bindMember = order.getMember();
        if (bindMember.getId() == null || "".equals(bindMember.getId())) {
            // 此时新建会员
            String uuid = UUID.randomUUID().toString().replace("-", "");
            bindMember.setId(uuid);
            memberService.saveMember(bindMember);
        } else {
            // 此时是已有会员
            Member old = memberService.findById(bindMember.getId());
            if (!bindMember.equals(old)) {
                // 更新已有会员
                memberService.updateMember(bindMember);
            }
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        order.setId(uuid);
        orderService.saveOrder(order);
        return "redirect:showOrderDetailsById?id=" + order.getId() + "&edit=true";
    }


}
