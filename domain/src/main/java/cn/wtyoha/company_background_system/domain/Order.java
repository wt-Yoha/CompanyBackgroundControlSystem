package cn.wtyoha.company_background_system.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Order {
    String id; // 订单 id
    String orderNum; // 订单编号
    Date orderTime; // 下单时间
    String orderTimeStr;
    int peopleCount; // 参加人数
    String orderDesc; // 订单描述
    int payType; // 支付类型
    String payTypeStr;
    int orderStatus; // 订单状态 0 未支付 1 已支付
    String orderStatusStr;
    String productName; // 对应产品名
    Product product; // 对应产品
    String memberName; // 对应会员名
    Member member; // 下单会员
    String[] traveller; // 参加游客编号

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        orderTimeStr = sdf.format(orderTime);
    }

    public String getOrderTimeStr() {
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) throws ParseException {
        this.orderTimeStr = orderTimeStr;
        orderTimeStr.replace("年", "-");
        orderTimeStr.replace("月", "-");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        orderTime = sdf.parse(orderTimeStr);
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
        switch (payType) {
            case 0:
                payTypeStr = "支付宝";
                break;
            case 1:
                payTypeStr = "微信";
                break;
            default:
                payTypeStr = "其他";
        }
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
        if ("支付宝".equals(payTypeStr)) {
            payType = 0;
        } else if ("微信".equals(payTypeStr)) {
            payType = 1;
        } else {
            payType = 2;
        }
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
        switch (orderStatus) {
            case 0:
                orderStatusStr = "未支付";
                break;
            case 1:
                orderStatusStr = "已支付";
                break;
        }
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
        if ("已支付".equals(orderStatusStr)) {
            orderStatus = 1;
        } else if ("未支付".equals(orderStatusStr)) {
            orderStatus = 0;
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String[] getTraveller() {
        return traveller;
    }

    public void setTraveller(String[] traveller) {
        this.traveller = traveller;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", product=" + product +
                ", member=" + member +
                ", traveller=" + Arrays.toString(traveller) +
                '}';
    }
}
