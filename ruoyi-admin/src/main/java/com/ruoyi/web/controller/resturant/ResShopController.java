package com.ruoyi.web.controller.resturant;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.resturant.domain.ResShop;
import com.ruoyi.resturant.service.IResShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Anonymous//匿名类
@RestController
@RequestMapping("/api/resturant/shop")
@Api(tags = "店铺管理")
public class ResShopController  extends BaseController {
    @Autowired
    private IResShopService resShopService;
    @ApiOperation("查询全部店铺列表")
    @GetMapping("/list0")
    public AjaxResult list0(){
        List<ResShop> list = resShopService.getAllResShops();
        return AjaxResult.success(list);
    }

    @ApiOperation(value = "获取店铺详细信息",notes = "TODD,获取某个店铺的详细信息")
    @ApiImplicitParam(name="id",value = "店铺id",required = true,dataType ="long",
            paramType = "path",dataTypeClass = Long.class)
    @GetMapping(value="/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(resShopService.selectResShopById(id));
    }
    @ApiOperation("按照名称查询店铺列表")
    @ApiImplicitParam(name = "name", value = "店铺名称",
            dataType = "string", dataTypeClass = String.class)
@GetMapping("/list")
    public AjaxResult list(@RequestParam(value = "name", required = false) String shopName) {
        List<ResShop> list = resShopService.selectShopByParam(shopName);
        return AjaxResult.success(list);}
    /**
     * 新增店铺
     */
    @ApiOperation("新增店铺")//3615张嘉慧
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ResShop resShop) {
        return AjaxResult.success(resShopService.insertResShop(resShop));
    }
    /**
     * 修改店铺
     */
    @ApiOperation("修改店铺")
    @PutMapping
    public AjaxResult edit(@RequestBody ResShop resShop) {
        return AjaxResult.success(resShopService.updateResShop(resShop));
    }
    /**
     * 删除店铺
     */

    @ApiOperation("删除店铺")
    @ApiImplicitParam(name = "id", value = "店铺ID", required = true, dataType = "long",
            paramType = "path", dataTypeClass = Long.class)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {

        return AjaxResult.success(resShopService.deleteResShopById(id));
    }
}
