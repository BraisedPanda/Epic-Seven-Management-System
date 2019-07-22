package com.braisedpanda.mapper;

import com.braisedpanda.bean.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    Category getCategoryByCid(String cid);

    List<Category> getAllCategory();
}
