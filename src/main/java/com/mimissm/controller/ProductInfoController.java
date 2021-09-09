package com.mimissm.controller;

import com.github.pagehelper.PageInfo;
import com.mimissm.pojo.ProductInfo;
import com.mimissm.service.ProductInfoService;
import com.mimissm.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/5 22:29
 */
@Controller
@RequestMapping("/product")
public class ProductInfoController {
    @Autowired
    ProductInfoService productInfoService;
    public static final int PAGE_SIZE = 5;
   public String saveFileName="";
    @RequestMapping("/getAllProduct")
    public String getAllProduct(HttpServletRequest request) {
        List<ProductInfo> all = productInfoService.getAll();
        request.setAttribute("list", all);
        return "product";
    }

    @RequestMapping("/split")
    public String split(HttpServletRequest request) {
        PageInfo pageInfo = productInfoService.spiltPage(1, PAGE_SIZE);
        request.setAttribute("info", pageInfo);
        return "product";
    }

    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int page, HttpSession session) {
        PageInfo pageInfo = productInfoService.spiltPage(page, PAGE_SIZE);
        session.setAttribute("info", pageInfo);

    }

    @ResponseBody
    @RequestMapping("/ajaxImage")
    public Object ajaxImage(MultipartFile pimage, HttpServletRequest request) {
//设置随机文件名uuid+上传图片的后缀名
      saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());
        String path = request.getServletContext().getRealPath("/image_big");
        //得到项目中图片存储的路径
        try {
            pimage.transferTo(new File(path + File.separator + saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //转存
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgurl", saveFileName);
        return jsonObject.toString();
    }

    @RequestMapping("/save")
    public String save(ProductInfo info,HttpServletRequest request) {
        info.setpImage(saveFileName);
        info.setpDate(new Date());
      int num=  productInfoService.save(info);
      if(num>0){
          request.setAttribute("msg","增加成功！");
      }else {
          request.setAttribute("msg","增加失败！");

      }
        return "forward:/product/split.action";
    }
}
