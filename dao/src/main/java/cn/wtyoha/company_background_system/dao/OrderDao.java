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

}
