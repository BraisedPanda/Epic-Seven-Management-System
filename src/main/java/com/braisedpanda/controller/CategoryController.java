package com.braisedpanda.controller;

import com.braisedpanda.bean.Category;
import com.braisedpanda.bean.Goods;
import com.braisedpanda.service.CategoryService;

import com.braisedpanda.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/allcategory")
    public ModelAndView allcategory(){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.getAllCategory();
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.setViewName("category/category");
        return modelAndView;

    }

    @RequestMapping("/optionalselect")

    public ModelAndView optionalselect(String[] selectedcategory1){
        ModelAndView modelAndView = new ModelAndView();
        int sel = selectedcategory1.length;
        System.out.println(sel);
        List<Category> categoryList = categoryService.getAllCategory();
        
            List<String> selectedcategory = new ArrayList();

            for (int i = 0; i < selectedcategory1.length; i++) {
                String s = selectedcategory1[i];

                selectedcategory.add(s);
            }


            List<Goods> goodsList = goodsService.findGoodsByCids(selectedcategory);
            for (Goods goods :
                    goodsList) {
                Category category = categoryService.getCategoryByCid(goods.getCid());
                goods.setCategory(category);
            }
            modelAndView.addObject("categoryList", categoryList);

            modelAndView.addObject("goodsList", goodsList);

            modelAndView.setViewName("select/findgoods");

        return modelAndView;

    }
}
