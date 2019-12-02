package cn.wtyoha.company_background_system.controller;

import cn.wtyoha.company_background_system.domain.Traveller;
import cn.wtyoha.company_background_system.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/traveller")
public class TravellerController {
    @Autowired
    @Qualifier("travellerServiceImpl")
    TravellerService travellerService;

    @RequestMapping("/editOrderUpdateTraveller")
    public String updateTraveller(Traveller traveller, String orderId) {
        travellerService.updateTraveller(traveller);
        return "redirect:/order/showOrderDetailsById?id="+orderId+"&edit=true";
    }

    @RequestMapping("/editOrderSaveTraveller")
    public String saveTravellerToOrder(Traveller traveller, String orderId) {
        if (traveller.getName() == null || "".equals(traveller.getName())) {
            return "redirect:/order/showOrderDetailsById?id="+orderId+"&edit=true";
        }
        travellerService.saveTravellerToOrder(traveller, orderId);
        return "redirect:/order/showOrderDetailsById?id="+orderId+"&edit=true";
    }

    @RequestMapping("/editOrderDeleteTraveller")
    public String deleteTravellerFromOrder(String travellerId, String orderId) {
        travellerService.deleteTravellerFromOrder(travellerId, orderId);
        return "redirect:/order/showOrderDetailsById?id="+orderId+"&edit=true";
    }
}
