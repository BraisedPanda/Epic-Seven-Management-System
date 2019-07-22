package com.braisedpanda.service;

import com.braisedpanda.bean.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CategoryService {
    Category getCategoryByCid(String cid);

    List<Category> getAllCategory();
}
