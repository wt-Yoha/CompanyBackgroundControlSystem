package cn.wtyoha.company_background_system.service.impl;

import cn.wtyoha.company_background_system.dao.TravellerDao;
import cn.wtyoha.company_background_system.dao.Traveller_OrderFormDao;
import cn.wtyoha.company_background_system.domain.Traveller;
import cn.wtyoha.company_background_system.domain.Traveller_Orderform;
import cn.wtyoha.company_background_system.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TravellerServiceImpl implements TravellerService {
    @Autowired
    TravellerDao travellerDao;

    @Autowired
    Traveller_OrderFormDao traveller_orderFormDao;

    @Override
    public List<Traveller> findAll() {
        return travellerDao.findAll();
    }

    @Override
    public Traveller findById(String id) {
        return travellerDao.findById(id);
    }

    @Override
    public List<Traveller> findByOrderId(String orderId) {
        return travellerDao.findByOrderId(orderId);
    }

    @Override
    public List<Traveller> findByMemberId(String memberId) {
        return travellerDao.findByMemberId(memberId);
    }

    @Override
    public void saveTraveller(Traveller traveller) {
        travellerDao.saveTraveller(traveller);
    }

    @Override
    public void updateTraveller(Traveller traveller) {
        travellerDao.updateTraveller(traveller);
    }

    @Override
    public void deleteTraveller(String id) {
        travellerDao.deleteTraveller(id);
    }

    @Override
    public void saveTravellerToOrder(Traveller traveller, String orderId) {
        traveller.setId(UUID.randomUUID().toString().replace("-", ""));
        travellerDao.saveTraveller(traveller);
        traveller_orderFormDao.saveATraveller_OrderForm(new Traveller_Orderform(traveller.getId(), orderId));
    }

    @Override
    public void deleteTravellerFromOrder(String travellerId, String orderId) {
        traveller_orderFormDao.deleteATraveller_OrderForm(new Traveller_Orderform(travellerId, orderId));
        if (traveller_orderFormDao.countTravellerBindingOrder(travellerId) <= 0) {
            travellerDao.deleteTraveller(travellerId);
        }
    }

    @Override
    public void addTravellerToOrder(String travellerId, String orderId) {
        traveller_orderFormDao.saveATraveller_OrderForm(new Traveller_Orderform(travellerId, orderId));
    }
}
