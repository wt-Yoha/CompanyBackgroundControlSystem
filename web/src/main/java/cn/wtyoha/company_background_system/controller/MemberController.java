package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Member;
import cn.wtyoha.company_background_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    @RequestMapping("/editOrderUpdateMember")
    public String editOrderUpdateMember(Member member, String orderId) {
        memberService.updateMember(member);
        return "redirect:/order/showOrderDetailsById?id="+orderId+"&edit=true";
    }

}
