package com.mimissm.Listener;

import com.mimissm.dao.ProductTypeDao;
import com.mimissm.pojo.ProductType;
import com.mimissm.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/6 16:50
 */
@WebListener
public class ProductTypeListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService typeServiceImpl = (ProductTypeService) context.getBean("productTypeServiceImpl");
        List<ProductType> all =typeServiceImpl.getAll();
        sce.getServletContext().setAttribute("typeList",all);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
