package cn.wtyoha.company_background_system.domain;

public class Traveller_Orderform {
    String travellerId;
    String orderformId;

    public Traveller_Orderform() {

    }

    public Traveller_Orderform(String travellerId, String orderformId) {
        this.travellerId = travellerId;
        this.orderformId = orderformId;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(String orderformId) {
        this.orderformId = orderformId;
    }
}
