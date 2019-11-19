package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.dao.Traveller_OrderFormDao;
import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.Traveller;
import cn.wtyoha.company_background_system.domain.Traveller_Orderform;
import cn.wtyoha.company_background_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    Traveller_OrderFormDao traveller_orderFormDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }

    // -------------------------- order 表是无法随便 delete 的， 它的 主键 是traveller_orderform 的外键
    @Override
    public void deleteOrder(String id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public void deleteOrderList(String[] ids) {
        for (String id : ids) {
            orderDao.deleteOrder(id);
        }
    }
    // -----------------------------------------------------------------------------------------------

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order); // 首先更新基本信息
        Set<Traveller> oldTravellers = new HashSet<>(orderDao.findById(order.getId()).getTravellers()); // 获取旧的关联旅客
        Set<Traveller> newTravellers = new HashSet<>(order.getTravellers()); // 获取新的关联旅客

        if (oldTravellers.containsAll(newTravellers) && newTravellers.containsAll(oldTravellers)) {
            // 新旧旅客表一致
            return;
        }

        for (Traveller oldTraveller : oldTravellers) {
            // 旧的旅客成员不在新的里面，表示旧的成员被删除
            if (!newTravellers.contains(oldTraveller)) {
                traveller_orderFormDao.deleteATraveller_OrderForm(new Traveller_Orderform(oldTraveller.getId(), order.getId())); // 新建一个 traveller_orderform 对象，第一项为travellerId
                oldTravellers.remove(oldTraveller);
            }
        }

        for (Traveller newTraveller : newTravellers) {
            if (!oldTravellers.contains(newTraveller)) {
                traveller_orderFormDao.saveATraveller_OrderForm(new Traveller_Orderform(newTraveller.getId(), order.getId()));
                newTravellers.remove(newTraveller);
            }
        }
    }

    @Override
    public void saveOrder(Order order) {

    }


}
