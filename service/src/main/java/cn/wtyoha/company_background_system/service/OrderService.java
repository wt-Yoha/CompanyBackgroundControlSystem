package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
}
