package com.braisedpanda.service;

import com.braisedpanda.bean.Goods;
import org.springframework.cache.annotation.CacheConfig;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
@CacheConfig(cacheNames = "goods")
public interface GoodsService {

    List<Goods> findAllGoods();

    Goods findGoodsByGid(String gid);

    void update(Goods goods);

    void delete(String gid);

    void addgoods(Goods goods);

    List<Goods> findGoodsByCid(String cid);

    List<Goods> findGoodByGname(String gname);

    List<Goods> findGoodsByCids(List<String> selectedcategory);
}
