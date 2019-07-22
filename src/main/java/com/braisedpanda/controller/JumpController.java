package com.braisedpanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/toFirstPage")
    public String toFirstPage(){
        return "menu/main";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/category")
    public String category(){
        return "category/category";
    }

    @RequestMapping("/tochart")
    public String tochart(){

        return "goods/chart";
    }

}
