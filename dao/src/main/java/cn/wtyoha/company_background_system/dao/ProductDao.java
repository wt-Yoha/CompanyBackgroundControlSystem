package cn.wtyoha.company_background_system.dao;

import cn.wtyoha.company_background_system.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll();

    @Update("insert into product values(REPLACE(UUID(), '-', ''), #{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void saveProduct(Product product);

    @Update("delete from product where productNum = #{pid}")
    void deleteProduct(String productNum);

    @Update("update product set productName = #{productName}, cityName=#{cityName}, departureTime=#{departureTime}, productPrice=#{productPrice}, productDesc=#{productDesc}, productStatus=#{productStatus} " +
            "where productNum = #{productNum}")
    void updateProduct(Product product);
}
