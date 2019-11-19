package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.OrderDao;
import cn.wtyoha.company_background_system.domain.Order;
import cn.wtyoha.company_background_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
