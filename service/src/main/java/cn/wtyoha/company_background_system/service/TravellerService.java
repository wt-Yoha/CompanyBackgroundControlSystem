package cn.wtyoha.company_background_system.service;

import cn.wtyoha.company_background_system.domain.Traveller;

import java.util.List;

public interface TravellerService {
    List<Traveller> findAll();

    Traveller findById(String id);

    List<Traveller> findByOrderId(String orderId);

    List<Traveller> findByMemberId(String memberId);

    void saveTraveller(Traveller traveller);

    void updateTraveller(Traveller traveller);

    void deleteTraveller(String id);

    void saveTravellerToOrder(Traveller traveller, String orderId);

    void deleteTravellerFromOrder(String travellerId, String orderId);

    void addTravellerToOrder(String travellerId, String orderId);
}
