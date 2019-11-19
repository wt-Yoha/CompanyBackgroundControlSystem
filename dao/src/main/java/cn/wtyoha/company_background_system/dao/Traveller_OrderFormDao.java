package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Traveller_Orderform;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface Traveller_OrderFormDao {

    @Update("insert into traveller_orderform values(#{travellerId}, #{orderformId})")
    public void saveATraveller_OrderForm(Traveller_Orderform traveller_orderform);

    @Update("delete from traveller_orderform where travellerId = #{travellerId} and orderformId = #{orderformId}")
    public void deleteATraveller_OrderForm(Traveller_Orderform traveller_orderform);
}
