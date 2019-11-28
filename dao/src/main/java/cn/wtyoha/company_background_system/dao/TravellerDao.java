package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TravellerDao {

    @Select("select * from traveller where id = #{id}")
    Traveller findById(String id);

    @Select("select * from traveller where id in (select t_o.travellerId from traveller_orderform t_o where t_o.orderformId = #{id})")
    List<Traveller> findByOrderId(String id);

    @Select("select * from traveller where id in (select t_o.travellerId from traveller_orderform t_o where t_o.orderformId in (select o.id from orderform o where o.memberId = #{mid}))")
    List<Traveller> findByMemberId(String id);

    @Update("insert into traveller values(#{id}, #{name}, #{sex}, #{phoneNum}, #{credentialsType}, #{credentialsNum}, #{travellerType})")
    void saveTraveller(Traveller traveller);

    @Update("delete from traveller where id = #{id}")
    void deleteTraveller(String id);

    @Select("select * from traveller")
    List<Traveller> findAll();

    @Update("update traveller set name=#{name}, sex=#{sex}, phoneNum=#{phoneNum}, credentialsType=#{credentialsType}, credentialsNum=#{credentialsNum}, travellerType=#{travellerType} where id = #{id}")
    void updateTraveller(Traveller traveller);
}
