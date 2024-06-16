package com.ruoyi.web.controller.resturant;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.resturant.domain.Banner;
import com.ruoyi.resturant.service.IBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ImageBanner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Anonymous
@Api(tags="轮播图管理")
@RestController
@RequestMapping("/api/Banner")
public class BannerController extends BaseController {
    @Autowired private IBannerService bannerService;
    @ApiOperation(value="取得所有轮播图列表", notes = "取得所有轮播图列表")
    @GetMapping("/list0")
    private AjaxResult list0(){

        List<Banner> allBanners =  bannerService.getAllBanners();
        return AjaxResult.success(allBanners);
    }
    @ApiOperation(value="取得轮播图列表",notes = "取得轮播图列表")

    @ApiImplicitParams({
            @ApiImplicitParam (name = "id",value = "轮播图id",dataType = "Long",
                    dataTypeClass = Long.class),
            @ApiImplicitParam (name = "pic",value = "轮播图图片",dataType = "String",
                    dataTypeClass = String.class),
            @ApiImplicitParam (name = "target_url",value = "轮播图网址",dataType = "String",
                    dataTypeClass = String.class),
            @ApiImplicitParam (name = "sort",value = "轮播图排序",dataType = "String",
                    dataTypeClass = String.class)
    })
    @GetMapping("/list")
    public AjaxResult list(Banner banner){
        List<Banner> list =bannerService.selectBannerList(banner);
        return AjaxResult.success(list);

    }
    @ApiOperation("根据id查找轮播图")
    @ApiImplicitParam(name = "id",value = "轮播图ID",
            required = true,dataType = "long",paramType = "path",
            dataTypeClass = Long.class)

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(bannerService.selectBannerById(id));
    }
    @ApiOperation("新增图片")
    @PostMapping//黄媛媛23201012020
//    @Validated数据校验
    public AjaxResult add(@Validated @RequestBody Banner banner){
        return AjaxResult.success(bannerService.insertBanner(banner));
    }
    @ApiOperation("修改图片信息")
    @PutMapping
    public AjaxResult edit(@RequestBody Banner Banner){
        return AjaxResult.success(bannerService.updateBanner(Banner));
    }
    /**
     * 删除图片信息
     */
    @ApiImplicitParam(name = "id", value = "学生ID",
            required = true, dataType = "long", paramType = "path",
            dataTypeClass = Long.class)
    @ApiOperation("删除图片")
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return AjaxResult.success
                (bannerService.deleteBannerById(id));
    }
}