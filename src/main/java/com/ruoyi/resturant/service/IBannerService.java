package com.ruoyi.resturant.service;
import com.ruoyi.resturant.domain.Banner;
import java.util.List;

public interface IBannerService {
    List<Banner> getAllBanners();
    /**
     * 查询轮播图列表
     */
    public List<Banner> selectBannerList(Banner banner);

    /**
     * 查询图片
     */
    public Banner selectBannerById(Long id);


    public int insertBanner(Banner banner);

    /**
     * 修改图片信息
     */
    public int updateBanner(Banner banner);

    /**
     * 删除图片信息
     */
    public int deleteBannerById(Long id);

}