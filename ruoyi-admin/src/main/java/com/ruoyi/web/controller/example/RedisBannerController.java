package com.ruoyi.web.controller.example;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.resturant.domain.Banner;
import com.ruoyi.resturant.service.IBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "Redis测试")
@Anonymous
@RestController
@RequestMapping("/api/redis")//请求路径
public class RedisBannerController {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IBannerService bannerService;
    @ApiOperation("传入图片id，将轮播图信息放入Redis缓存")
    @ApiImplicitParam(name = "id",value = "轮播图id",required = true,dataType = "long",paramType = "query",dataTypeClass = long.class)
    @GetMapping("/putBannerObj")
    public AjaxResult putObj(@RequestParam Long id) {
        Banner banner = bannerService.selectBannerById(id);
        String joinStr = JSON.toJSONString(banner);
        redisCache.setCacheObject(String.valueOf(banner.getId()),joinStr,1, TimeUnit.HOURS);
        return AjaxResult.success(banner);
    }
    @ApiOperation("传入图片id，从redis中读取轮播图数据")
    @ApiImplicitParam(name = "id",value = "轮播图id",required = true,dataType = "long",paramType = "query",dataTypeClass = long.class)
    @GetMapping("/getBannerObj")
    public AjaxResult getObj(@RequestParam Long id) {
        String v =redisCache.getCacheObject(String.valueOf(id));
        Banner banner=JSON.parseObject(v,Banner.class);
        return AjaxResult.success(banner);
    }
}
