package com.mimissm.service.impl;

import com.mimissm.dao.AdminDao;
import com.mimissm.pojo.Admin;
import com.mimissm.pojo.AdminExample;
import com.mimissm.service.AdminService;
import com.mimissm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 15:28
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin login(String name, String password) {
        AdminExample adminExample = new AdminExample();
        /**
         * 对查询添加条件
         * select * from xx (where name="" )相当于条件
         */
        adminExample.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminDao.selectByExample(adminExample);
        if (admins.size() > 0) {
            Admin admin = admins.get(0);
            String miPassword = MD5Util.getMD5(password);
            System.out.println("密码："+miPassword);
            System.out.println("密码："+admin.getaPass());
            if (miPassword.equals(admin.getaPass())) {
                return admin;
            }
        }
        return null;
    }


}
