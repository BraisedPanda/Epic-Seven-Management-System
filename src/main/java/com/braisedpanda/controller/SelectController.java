package com.braisedpanda.controller;

import com.braisedpanda.bean.Category;
import com.braisedpanda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SelectController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/select")
    public ModelAndView select(){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.getAllCategory();
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.setViewName("select/select");
        return modelAndView;
    }
}
