package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysLogDao {

    @Select("select * from logs order by visitTime desc")
    List<SysLog> findAll();

    @Insert("insert into logs values(#{id}, #{visitTime}, #{userName}, #{ip}, #{url}, #{executeTime}, #{method})")
    void save(SysLog sysLog);

}
