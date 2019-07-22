package com.braisedpanda.serviceImpl;

import com.braisedpanda.bean.Goods;
import com.braisedpanda.mapper.GoodsMapper;
import com.braisedpanda.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsServiceImpl  implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoods() {
        List<Goods> goodsList = goodsMapper.findAllGoods();
        return goodsList;

    }

    @Override
    public Goods findGoodsByGid(String gid) {
      Goods goods =   goodsMapper.findGoodsByGid(gid);
      return goods;
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public void delete(String gid) {
        goodsMapper.delete(gid);
    }

    @Override
    public void addgoods(Goods goods) {
        goodsMapper.addgoods(goods);
    }

    @Override
    public List<Goods> findGoodsByCid(String cid) {
        List<Goods> goodsList=goodsMapper.findGoodsByCid(cid);
        return  goodsList;
    }

    @Override
    public List<Goods> findGoodByGname(String gname) {
        List<Goods> goodsList = goodsMapper.findGoodByGname(gname);
        return goodsList;
    }

    @Override
    public List<Goods> findGoodsByCids(List<String> selectedcategory) {
        List<Goods> goodsList = goodsMapper.findGoodsByCids(selectedcategory);
        return goodsList;
    }
}
