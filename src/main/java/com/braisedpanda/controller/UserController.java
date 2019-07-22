package com.braisedpanda.controller;

import com.braisedpanda.bean.Category;
import com.braisedpanda.bean.Goods;
import com.braisedpanda.bean.User;
import com.braisedpanda.mapper.UserMapper;
import com.braisedpanda.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("user/{uid}")
    public String findUserById(@PathVariable("uid") String uid){
        long startTime = System.currentTimeMillis();

        User user = userService.findUserById(uid);
        long endTime = System.currentTimeMillis();

        System.out.println("执行时间："+(endTime-startTime)+"毫秒");

        return null;
    }

    @PostMapping("/login")
    public ModelAndView login(String username, String password, Model model, HttpSession session){
        User user1 =  userService.findUser(username,password);
        ModelAndView modelAndView = new ModelAndView();
        if(user1 == null){

            modelAndView.addObject("msg","用户名或密码错误~！");
            modelAndView.setViewName("index");

            return modelAndView;
        }
        modelAndView.setViewName("menu/main");

        session.setAttribute("user",user1);
        return modelAndView;
    }

    @GetMapping("/regist")
    public String toRegist(){
        return "user/regist";
    }

    @PostMapping("/regist")
    public String regist(User user){
        userService.addUser(user);
        return "index";
    }

    @RequestMapping("/edit/main")
    public String main(){
        return "menu/main";
    }

    @RequestMapping("tomenu")
    public String menu(){
        return "menu/goods";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index";
    }

    @RequestMapping(value = "/allusers/{startPage}")
    public ModelAndView allGoods(@PathVariable("startPage") Integer startPage) {
        ModelAndView modelAndView = new ModelAndView();

        int totalCount = userService.findAllUsers().size();
        PageHelper.startPage(startPage, 15);
        List<User> userList = userService.findAllUsers();


        //计算出总的属性
        int totalPage;


        if (totalCount % 15 == 0) {
            totalPage = totalCount / 15;
        } else {
            totalPage = totalCount / 15 + 1;
        }


        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        List<User> pageList = userPageInfo.getList();
        modelAndView.addObject("userList", pageList);
        modelAndView.addObject("totalPage", totalPage);
        modelAndView.addObject("startPage", startPage);

        modelAndView.setViewName("user/users");
        return modelAndView;
    }
    @PostMapping("/adduser")
    public String addUser(User user){
        String uid = UUID.randomUUID()+"";
        uid = uid.replace("-","");
        user.setUid(uid);
        userService.addUser(user);
        return "redirect:/allusers/1";
    }

    @RequestMapping("/finduser")
    public ModelAndView finduser(String username){

        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.findUserByUsername(username);


        modelAndView.addObject("userList",userList);

        modelAndView.setViewName("user/findusers");
        return modelAndView;
    }

    @RequestMapping("/user/edit/{uid}/modify")
    public String edit(User user,@PathVariable("uid") String uid)  {


        userService.update(user);


        return "redirect:/allusers/1";
    }

    @GetMapping("/user/edit/{uid}")
    public ModelAndView edit(@PathVariable("uid") String uid) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserById(uid);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("user/edit");

        return modelAndView;
    }

    @RequestMapping("user/delete/{uid}")
    public String delete(@PathVariable("uid") String uid) {
        userService.delete(uid);
        return "redirect:/allusers/1";
    }

    @RequestMapping("/myinfo")
    public ModelAndView myinfo(HttpSession session) {
        User user1 = (User)session.getAttribute("user");
        String uid = user1.getUid();
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserById(uid);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("user/editmyinfo");

        return modelAndView;
    }

    @RequestMapping("/editmyinfo/{uid}")
    public String editmyinfo(User user,@PathVariable("uid") String uid)  {


        userService.update(user);


        return "redirect:/index";
    }
}
