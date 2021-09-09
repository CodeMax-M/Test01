package com.mimissm.service;

import com.github.pagehelper.PageInfo;
import com.mimissm.pojo.ProductInfo;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 19:06
 */
public interface ProductInfoService {
    //    查询所有数据，不分页
    public abstract List<ProductInfo> getAll();

    //    分页功能的实现
    public abstract PageInfo spiltPage(int pageNum, int pageSize);

    //插入数据
    public abstract int save(ProductInfo info);
}
