package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll(int currentPage, int pageSize);

    Order findById(String id);

    void deleteOrder(String id);

    void deleteOrderList(String[] ids);

    void updateOrderBase(Order order);

    void saveOrder(Order order);
}
