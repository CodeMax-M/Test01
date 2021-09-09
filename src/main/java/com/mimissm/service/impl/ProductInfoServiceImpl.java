package com.mimissm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mimissm.dao.ProductInfoDao;
import com.mimissm.dao.ProductTypeDao;
import com.mimissm.pojo.ProductInfo;
import com.mimissm.pojo.ProductInfoExample;
import com.mimissm.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 19:07
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDao productInfoDao;

    public List<ProductInfo> getAll() {

        return productInfoDao.selectByExample(new ProductInfoExample());
    }

    public PageInfo spiltPage(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum, pageSize);
        //进行PageInfo的数据封装
        //进行有条件的查询操作，必须创建ProductInfoExample对象
        ProductInfoExample productInfoExample = new ProductInfoExample();
        //设置排序，按主键降序排序
        //select * from product_info order by p_id desc
        productInfoExample.setOrderByClause("p_id desc");
        //设置完排序后，取集合
        List<ProductInfo> productInfos = productInfoDao.selectByExample(productInfoExample);
     //将查询到的集合封装进PageInfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo(productInfos);
        return pageInfo;
    }

    public int save(ProductInfo info) {
        int count = productInfoDao.insert(info);
        return count;
    }
}
