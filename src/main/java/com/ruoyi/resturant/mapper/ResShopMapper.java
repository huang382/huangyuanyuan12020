package com.ruoyi.resturant.mapper;

import com.ruoyi.resturant.domain.ResShop;
import com.ruoyi.resturant.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResShopMapper {
    List<ResShop> queryAll();
    public ResShop selectResShopById(Long id);
    public List<ResShop> selectShopByParam(String name);
    public int insertResShop(ResShop resShop);
    public int updateResShop(ResShop resShop);
    public int deleteResShopById(Long id);
}
