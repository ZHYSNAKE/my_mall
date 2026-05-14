package com.demo.mymall.service;

import com.demo.mymall.entity.Goods;
import java.util.List;

//业务逻辑接口

public interface GoodsService {
    // 查询所有商品
    List<Goods> findAllGoods();

    // 根据关键字搜索商品
    List<Goods> searchGoods(String keyword);
}