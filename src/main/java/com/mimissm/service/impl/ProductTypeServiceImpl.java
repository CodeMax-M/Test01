package com.mimissm.service.impl;

import com.mimissm.dao.ProductTypeDao;
import com.mimissm.pojo.ProductType;
import com.mimissm.pojo.ProductTypeExample;
import com.mimissm.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/6 16:38
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
   @Autowired
    public ProductTypeDao productTypeDao;
    public List<ProductType> getAll() {
        return productTypeDao.selectByExample(new ProductTypeExample());
    }
}
