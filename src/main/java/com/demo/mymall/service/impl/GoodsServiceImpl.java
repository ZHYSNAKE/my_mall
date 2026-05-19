package com.demo.mymall.service.impl;

import com.demo.mymall.entity.Goods;
import com.demo.mymall.mapper.GoodsMapper;
import com.demo.mymall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//业务逻辑实现

@Service//告诉 Spring：这个类是业务逻辑层，请帮我创建它的对象，用 @Autowired 就能拿过去。
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;  // 注入 Mapper，用来操作数据库

    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public List<Goods> searchGoods(String keyword) {
        return goodsMapper.searchGoods(keyword);
    }

    @Override
    public Goods findGoodsById(int id) {
        return goodsMapper.findGoodsById(id);
    }
}