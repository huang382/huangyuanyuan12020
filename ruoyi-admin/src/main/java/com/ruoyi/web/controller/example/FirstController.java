package com.ruoyi.web.controller.example;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Anonymous//匿名类 不需要登录
@RestController
@RequestMapping("/example")//地址
public class FirstController {
    @Value("${ruoyi.name}")
    private  String ruoyiName;
    @Value("${ruoyi.version}")
    private  String ruoyiVersion;

    @GetMapping("/first")
    public String Hello () {
        return "若依名字： "+ruoyiName + " 若依版本: "+ ruoyiVersion;
    }

}
