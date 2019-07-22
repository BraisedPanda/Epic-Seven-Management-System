package com.braisedpanda.mapper;

import com.braisedpanda.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsMapper {

    Goods findGoodsByGid(String gid);

    List<Goods> findAllGoods();

    void update(Goods goods);

    void delete(String gid);

    void addgoods(Goods goods);

    List<Goods> findGoodsByCid(String cid);

    List<Goods> findGoodByGname(String gname);

    List<Goods> findGoodsByCids(@Param("selectedcategory") List<String> selectedcategory);
}
