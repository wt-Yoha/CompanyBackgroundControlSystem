package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TravellerDao {

    @Select("select * from traveller where id = #{id}")
    Traveller findById(String id);

    @Select("select * from traveller where id in (select t_o.travellerId from traveller_orderform t_o where t_o.orderformId = #{id})")
    List<Traveller> findByOrderId(String id);

}
