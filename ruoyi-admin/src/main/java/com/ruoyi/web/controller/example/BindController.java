package com.ruoyi.web.controller.example;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.example.pojo.Product;
import com.ruoyi.example.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Anonymous
@RestController
@RequestMapping("/bind")
public class BindController extends BaseController {
    @GetMapping("/userId")
    public String getUserId(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        System.out.println("userid=" + userid);
        return userid;
    }

    @GetMapping("/userName")//带参数的
    public String getUserName(@RequestParam(value = "name",
            required = false, defaultValue = "默认名字") String username) {
        System.out.println("username=" + username);
        return username;
    }
    @GetMapping("/user/{name}")//不是铭文上带参数了
    public String getPathVariable(@PathVariable(value = "name")
                                  String username){
        System.out.println("username="+username);
        return username;
    }
    // 获取商品列表
    @PostMapping ("/products")//复杂类型
    public String getProducts(@RequestBody Product[] products) {
        for (int i=0;i < products.length;i++) {
            System.out.println("获取的订单id为："+products[0].getProId());
        }
        return "";
    }
    @PostMapping("/user")
    // @RequestBody将json 数据映射到User 对象中
    public  String json(@RequestBody User user){
        System.out.println(user.getName().toString());
        System.out.println(user.getOrderIds()[0].toString());
        System.out.println(user.getPhone().get("常用"));
        return "ok";
    }
}
