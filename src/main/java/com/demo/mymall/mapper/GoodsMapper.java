package com.demo.mymall.mapper;

import com.demo.mymall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

//操作数据库的接口

@Mapper
public interface GoodsMapper {
    // 原有方法：查询所有商品
    List<Goods> findAllGoods();

    // 新增方法：根据关键字搜索商品
    List<Goods> searchGoods(String keyword);
}