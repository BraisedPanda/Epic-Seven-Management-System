package com.braisedpanda.controller;

import com.braisedpanda.bean.Category;
import com.braisedpanda.bean.Chart;
import com.braisedpanda.bean.Goods;
import com.braisedpanda.service.CategoryService;
import com.braisedpanda.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.LLOAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/allgoods/{startPage}")
    public ModelAndView allGoods(@PathVariable("startPage") Integer startPage) {
        ModelAndView modelAndView = new ModelAndView();

        int totalCount = goodsService.findAllGoods().size();
        PageHelper.startPage(startPage, 5);
        List<Goods> goodsList = goodsService.findAllGoods();
        List<Category> categoryList = categoryService.getAllCategory();
        //为每个Goods设置category属性
        for (Goods goods :
                goodsList) {
            Category category = categoryService.getCategoryByCid(goods.getCid());
            goods.setCategory(category);

        }
        //计算出总的属性
        int totalPage;


        if (totalCount % 5 == 0) {
            totalPage = totalCount / 5;
        } else {
            totalPage = totalCount / 5 + 1;
        }


        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        List<Goods> pageList = goodsPageInfo.getList();
        modelAndView.addObject("goodsList", pageList);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("menu/goods");
        return modelAndView;
    }

    @GetMapping("/edit/{gid}")
    public ModelAndView edit(@PathVariable("gid") String gid) {
        ModelAndView modelAndView = new ModelAndView();
        Goods goods = goodsService.findGoodsByGid(gid);
        List<Category> categoryList = categoryService.getAllCategory();
        Category category = categoryService.getCategoryByCid(goods.getCid());
        goods.setCategory(category);
        modelAndView.addObject("goods", goods);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("goods/edit");

        return modelAndView;
    }

    @RequestMapping("/edit/{gid}/modify")
    public String edit(Goods goods, MultipartFile file, @PathVariable("gid") String gid, String cid) throws Exception {

        String orginalFileName = file.getOriginalFilename();
        if (file != null && orginalFileName != null && orginalFileName.length() > 0) {
            String file_path = "F:\\mycode\\JDBCTest01\\src\\main\\resources\\static\\lib\\images\\";
            String fileName = UUID.randomUUID() + orginalFileName.substring(orginalFileName.lastIndexOf("."));
            fileName = fileName.replace("-", "");
            File newFile = new File(file_path + fileName);
            file.transferTo(newFile);
            System.out.println(fileName);
            goods.setImage(fileName);
        }
        goodsService.update(goods);
        System.out.println(goods);

        return "redirect:/allgoods/1";
    }

    @RequestMapping("delete/{gid}")
    public String delete(@PathVariable("gid") String gid) {
        goodsService.delete(gid);
        return "redirect:/allgoods/1";
    }

    @RequestMapping("allgoods/1/add")
    public String addgoods(MultipartFile file,Goods goods) throws Exception{
        String gid = UUID.randomUUID()+"";
        gid = gid.replace("-","");
        goods.setGid(gid);
        String orginalFileName = file.getOriginalFilename();
        if (file != null && orginalFileName != null && orginalFileName.length() > 0) {
            String file_path = "F:\\mycode\\JDBCTest01\\src\\main\\resources\\static\\lib\\images\\";
            String fileName = UUID.randomUUID() + orginalFileName.substring(orginalFileName.lastIndexOf("."));
            fileName = fileName.replace("-", "");
            File newFile = new File(file_path + fileName);
            file.transferTo(newFile);

            goods.setImage(fileName);
        }
        goodsService.addgoods(goods);
        System.out.println(goods);

        return "redirect:/allgoods/1";
    }
   //查找各个分类的商品
    @RequestMapping("/category/{cid}/{startPage}")
    public ModelAndView findCategory(@PathVariable("startPage") Integer startPage,
                                     @PathVariable("cid") String cid) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(cid);
        System.out.println(startPage);
        int totalCount = goodsService.findGoodsByCid(cid).size();
        PageHelper.startPage(startPage, 5);
        List<Goods> goodsList = goodsService.findGoodsByCid(cid);

        List<Category> categoryList = categoryService.getAllCategory();
        //为每个Goods设置category属性
        for (Goods goods :
                goodsList) {
            Category category = categoryService.getCategoryByCid(cid);
            goods.setCategory(category);

        }
        //计算出总的属性
        int totalPage;


        if (totalCount % 5 == 0) {
            totalPage = totalCount / 5;
        } else {
            totalPage = totalCount / 5 + 1;
        }


        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        List<Goods> pageList = goodsPageInfo.getList();
        modelAndView.addObject("cid", cid);
        modelAndView.addObject("goodsList", pageList);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("menu/findgoods");
        return modelAndView;
    }

    @RequestMapping("/findgood")
    public ModelAndView findgood(String gname){
        System.out.println(gname);
        ModelAndView modelAndView = new ModelAndView();
        List<Goods> goodsList = goodsService.findGoodByGname(gname);
        String cid = goodsList.get(0).getCid();
        for (Goods goods :
                goodsList) {
            Category category = categoryService.getCategoryByCid(cid);
            goods.setCategory(category);

        }
        List<Category> categoryList = categoryService.getAllCategory();
        modelAndView.addObject("goodsList",goodsList);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("menu/findgname");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/chart")
    public List<Chart> testjson(){
        List<Category> categoryList = categoryService.getAllCategory();
        List<Chart> chartList = new ArrayList();
        for (Category category : categoryList) {
            Chart chart = new Chart();
            chart.setChartName(category.getCname());

            List<Goods> goodsList = goodsService.findGoodsByCid(category.getCid());
            int count =goodsList.size();
            chart.setValue((double)count);
            chartList.add(chart);
        }

        return chartList;
    }
}
