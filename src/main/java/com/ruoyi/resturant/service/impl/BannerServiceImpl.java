package com.ruoyi.resturant.service.impl;

import com.ruoyi.resturant.domain.Banner;
import com.ruoyi.resturant.mapper.BannerMapper;
import com.ruoyi.resturant.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired

    private BannerMapper bannerMapper;

    public List<Banner> getAllBanners(){
        return  bannerMapper.queryAll();
    }
    @Override
    public List<Banner> selectBannerList(Banner Banner){
        return bannerMapper.selectBannerList(Banner);
    }
    @Override
    public Banner selectBannerById(Long id){
        return bannerMapper.selectBannerById(id);
    }
    @Override
    public int insertBanner(Banner banner){
        return bannerMapper.insertBanner(banner);
    }
    @Override
    public int updateBanner(Banner banner){
        return bannerMapper.updateBanner(banner);
    }
    @Override
    public int deleteBannerById(Long id){
        return bannerMapper.deleteBannerById(id);
    }

}


