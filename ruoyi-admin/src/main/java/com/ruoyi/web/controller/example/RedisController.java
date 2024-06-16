package com.ruoyi.web.controller.example;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.resturant.domain.ResShop;
import com.ruoyi.resturant.service.IResShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "Redis测试")
@Anonymous
@RestController
@RequestMapping("/api/redis")
public class RedisController {
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private IResShopService resShopService;
    @ApiOperation("传入id，查询店铺信息，将店铺信息放入Redis缓存")
    @ApiImplicitParam(name = "id",value = "店铺id",required = true,dataType = "long",paramType = "query",dataTypeClass = long.class)
    @GetMapping("/putObj")
    public AjaxResult putObj(@RequestParam Long id) {
        ResShop resShop = resShopService.selectResShopById(id);
        String joinStr = JSON.toJSONString(resShop);
        redisCache.setCacheObject(String.valueOf(resShop.getId()),joinStr,1, TimeUnit.HOURS);
        return AjaxResult.success(resShop);
    }
    @ApiOperation("传入id，从redis中读取数据")
    @ApiImplicitParam(name = "id",value = "店铺id",required = true,dataType = "long",paramType = "query",dataTypeClass = long.class)
    @GetMapping("/getObj")
    public AjaxResult getObj(@RequestParam Long id) {
        String v =redisCache.getCacheObject(String.valueOf(id));
        ResShop resShop=JSON.parseObject(v,ResShop.class);
        return AjaxResult.success(resShop);
    }
}
