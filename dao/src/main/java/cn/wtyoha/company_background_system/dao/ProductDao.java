package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select * from product")
    public List<Product> findAll();
}
