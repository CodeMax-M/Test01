package com.mimissm.service;

import com.mimissm.pojo.Admin;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 15:26
 */
public interface AdminService {
    public abstract Admin login(String name, String password);
}
