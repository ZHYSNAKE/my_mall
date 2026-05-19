package com.demo.mymall.controller;

import com.demo.mymall.entity.Goods;
import com.demo.mymall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//处理浏览器请求

@Controller//标记这个类是一个"控制器"，专门接收用户的请求并返回响应
public class GoodsController {

    @Autowired//Spring 自动创建对象
    private GoodsService goodsService;

//    @GetMapping("/")//表示把方法绑定到指定的 URL 地址上
//    public String listGoods(Model model) {//Model 是 Spring 提供的一个数据容器，用来在 Controller 和页面之间传递数据
//        List<Goods> goodsList = goodsService.findAllGoods();
//
//        // 把 goodsList 装起来，标签叫 "goodsList"
//        model.addAttribute("goodsList", goodsList);
//
//        // 把 当前时间 装起来，标签叫 "currentTime"
//        model.addAttribute("currentTime", java.time.LocalDateTime.now());
//        return "goods/list";//告诉 Spring：用 goods/list.html 这个模板去显示页面；Spring约定从templates里找
//    }

    /**
     * 处理首页请求
     * @param keyword 搜索关键字（从 URL 参数 ?keyword=xxx 获取，可选）
     * @param model 数据模型，用来传递数据给页面
     * @return 页面名称
     */
    @GetMapping("/")
    public String listGoods(
            @RequestParam(value = "keyword", required = false) String keyword,  // 看 URL 地址里的 ?key=value，把 value 取出来给 Java 变量用
            Model model) {//Model 是 Spring 提供的一个数据容器，用来在 Controller 和页面之间传递数据

        List<Goods> goodsList;  // 声明商品列表变量

        // 判断：有关键字且不是空字符串
        if (keyword != null && !keyword.trim().isEmpty()) { //.trim()去掉字符串首尾的空格
            // 情况1：有关键字 → 执行搜索
            goodsList = goodsService.searchGoods(keyword);
            model.addAttribute("keyword", keyword);  // 把关键字存回页面，让输入框保留显示
        } else {
            // 情况2：没有关键字 → 查询全部
            goodsList = goodsService.findAllGoods();
        }

        // 把 goodsList 装起来，标签叫 "goodsList"
        model.addAttribute("goodsList", goodsList);

        // 把 当前时间 装起来，标签叫 "currentTime"
        model.addAttribute("currentTime", java.time.LocalDateTime.now());
        return "goods/list";//告诉 Spring：用 goods/list.html 这个模板去显示页面；Spring约定从templates里找
    }

    @GetMapping("/goods/{id}")
    public String details(
                          @PathVariable int id, //@PathVariable 从URL里获取数据
                          Model model){
        Goods goods = goodsService.findGoodsById(id);
        model.addAttribute("goods", goods);
        return "goods/details";
    }

    @GetMapping("/goods/buy")
    public String buy(
            @PathVariable int id, //@PathVariable 从URL里获取数据
            Model model){
        Goods goods = goodsService.findGoodsById(id);
        model.addAttribute("goods", goods);
        return "goods/details";
    }
}

