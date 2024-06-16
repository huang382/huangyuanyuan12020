package com.ruoyi.resturant.mapper;

import com.ruoyi.resturant.domain.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    //接口只有声明
    List<Banner> queryAll();

    public List<Banner> selectBannerList(Banner banner);


    /**
     * 查询图片
     *

     */
    public Banner selectBannerById(Long id);



    public int insertBanner(Banner banner);


    public int updateBanner(Banner banner);

    /**
     * 删除图片

     */
    public int deleteBannerById(Long id);
}
