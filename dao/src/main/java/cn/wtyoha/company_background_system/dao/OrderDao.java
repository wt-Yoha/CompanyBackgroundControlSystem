package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Select("select * from orderform")
    @Results({
            @Result(column = "productId", property = "product", one=@One(select = "cn.wtyoha.company_background_system.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member", one = @One(select = "cn.wtyoha.company_background_system.dao.MemberDao.findById"))
    })
    List<Order> findAll();

    @Select("SELECT o.*, m.`name`, p.`productName` "+
            "FROM orderform o, member m, product p "+
            "WHERE "+
            "o.`memberId` = m.`id` AND "+
            "o.`productId` = p.`id` ")
    List<Order> findALL2();


    @Select("select * from orderform where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "productId", property = "product", one = @One(select = "cn.wtyoha.company_background_system.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member", one = @One(select = "cn.wtyoha.company_background_system.dao.MemberDao.findById")),
            @Result(column = "id", property = "travellers", many = @Many(select = "cn.wtyoha.company_background_system.dao.TravellerDao.findByOrderId")),
            @Result(column = "id", property = "peopleCount", one = @One(select = "cn.wtyoha.company_background_system.dao.Traveller_OrderFormDao.countOrderBindingTraveller"))
    })
    Order findById(String id);

    @Update("delete from orderform where id = #{id}")
    void deleteOrder(String id);

    @Update("update orderform set orderNum = #{orderNum}, " +
            "orderTime = #{orderTimeStr}, " +
            "peopleCount = #{peopleCount}, " +
            "orderDesc = #{orderDesc}, " +
            "orderStatus = #{orderStatus}, " +
            "productId = #{product.id}, " +
            "memberId = #{member.id} "+
            "where id = #{id}")
    void updateOrder(Order order);

    @Update("update orderform set orderNum = #{orderNum}, " +
            "orderTime = #{orderTimeStr}, " +
            "orderDesc = #{orderDesc}, " +
            "productId = #{product.id} " +
            "where id = #{id}")
    void updateOrderBase(Order order);

    @Update("insert into orderform(id, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)" +
            " values (#{id}, " +
            "#{orderNum}, "+
            "#{orderTimeStr}, " +
            "#{peopleCount}, " +
            "#{orderDesc}, " +
            "#{payType}, " +
            "#{orderStatus}, " +
            "#{product.id}, " +
            "#{member.id}) ")
    void saveOrder(Order order);

    @Update("update orderform set orderStatus = 1 where id = #{id}")
    void openOrder(String id);

    @Update("update orderform set orderStatus = 0 where id = #{id}")
    void closeOrder(String id);
}
