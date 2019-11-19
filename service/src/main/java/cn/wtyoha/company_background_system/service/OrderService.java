package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(String id);

    void deleteOrder(String id);

    void deleteOrderList(String[] ids);

    void updateOrder(Order order);

    void saveOrder(Order order);
}
