package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.dao.TravellerDao;
import cn.wtyoha.company_background_system.dao.Traveller_OrderFormDao;
import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.domain.Traveller;
import cn.wtyoha.company_background_system.domain.Traveller_Orderform;
import cn.wtyoha.company_background_system.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    TravellerDao travellerDao;

    @Autowired
    Traveller_OrderFormDao traveller_orderFormDao;


    @Override
    public List<Order> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public void deleteOrderList(String[] ids) {

    }

    @Override
    public void updateOrderBase(Order order) {
        // 更新 order 表的以下几个区域： orderNum, orderTime, product, orderDesc
        orderDao.updateOrderBase(order);
    }

    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }
}
