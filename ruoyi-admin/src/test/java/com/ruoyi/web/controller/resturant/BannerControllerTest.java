package com.ruoyi.web.controller.resturant;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.resturant.domain.Banner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BannerControllerTest {
    @Autowired//自动注入
    private BannerController bannerController;
    @Test//测试添加一个新的轮播图记录是否成功
    public void testadd() {
        Banner newBanner = new Banner();
        newBanner.setName("测试图片1");
        newBanner.setPic("0");
        newBanner.setTarget_url("000002");
        AjaxResult result1 = bannerController.add(newBanner);

// 断言返回的AjaxResult对象中的success属性为true，表示添加操作成功。
        // 断言：返回的状态是success
        Assertions.assertTrue(result1.isSuccess());
    }

    @Test
    public void testremove() {
        // 删除存在的图片
        AjaxResult result = bannerController.remove(14L);
        // 断言：返回的状态是success
        Assertions.assertTrue(result.isSuccess());
        int deleteDatas = (int)result.get("data");
        // 断言：删除用户数1条
        Assertions.assertEquals(deleteDatas, 1);
        // 删除不存在的图片
        AjaxResult result1 = bannerController.remove(999L);
        int deleteDatas1 = (int)result1.get("data");
        // 断言：删除用户数0条
        Assertions.assertEquals(deleteDatas1, 0);
    }
}
