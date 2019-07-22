package com.braisedpanda.serviceImpl;

import com.braisedpanda.bean.Category;
import com.braisedpanda.mapper.CategoryMapper;
import com.braisedpanda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category getCategoryByCid(String cid) {
        Category category = categoryMapper.getCategoryByCid(cid);
        return  category;
    }

    @Override
    public List<Category> getAllCategory() {
       List<Category> categoryList =  categoryMapper.getAllCategory();
       return categoryList;
    }
}
