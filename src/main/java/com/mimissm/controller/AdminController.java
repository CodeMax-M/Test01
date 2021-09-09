package com.mimissm.controller;

import com.mimissm.pojo.Admin;
import com.mimissm.service.AdminService;
import com.mimissm.service.impl.AdminServiceImpl;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 16:47
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //    实现登录判断，并进行相应的跳转
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
//登录成功
            request.setAttribute("admin",admin);
            return "main";
        } else {
            request.setAttribute("errmsg","用户名或密码错误！");
            return "login";
        }
    }
}
