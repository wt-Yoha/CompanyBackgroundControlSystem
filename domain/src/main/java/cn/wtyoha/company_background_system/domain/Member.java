package cn.wtyoha.company_background_system.domain;

import java.util.Arrays;
import java.util.Objects;

public class Member {
    // 会员表
    String id;
    String name;
    String nickName;
    String phoneNum;
    String email;
    Order[] orders;
    Traveller[] travellers;

    public Traveller[] getTravellers() {
        return travellers;
    }

    public void setTravellers(Traveller[] travellers) {
        this.travellers = travellers;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id.equals(member.id) &&
                name.equals(member.name) &&
                nickName.equals(member.nickName) &&
                Objects.equals(phoneNum, member.phoneNum) &&
                Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickName, phoneNum, email);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + Arrays.toString(orders) +
                ", travellers=" + Arrays.toString(travellers) +
                '}';
    }
}
