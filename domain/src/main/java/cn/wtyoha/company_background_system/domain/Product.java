package cn.wtyoha.company_background_system.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    String id;
    String productNum;
    String productName;
    String cityName;
    Date departureTime;
    String departureTimeStr;
    Double productPrice;
    String productDesc;
    int productStatus;
    String productStatusStr;

    public void setDepartureTimeStr(String departureTimeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.departureTimeStr = departureTimeStr;
        departureTime = sdf.parse(departureTimeStr);
        setDepartureTime(departureTime);
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
        if ("开启".equals(productStatusStr))
            setProductStatus(1);
        else
            setProductStatus(0);
    }

    public String getDepartureTimeStr() {
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        return productStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        departureTimeStr = simpleDateFormat.format(departureTime);
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
        productStatusStr = productStatus == 1 ? "开启" : "未开启";
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
