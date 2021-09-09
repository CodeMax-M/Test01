package com.mimissm.dao;

import com.mimissm.pojo.Admin;
import com.mimissm.pojo.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    long countByExample(AdminExample example);

    long countByExample1(AdminExample example);

    long countByExample2(AdminExample example);

    long countByExample3(AdminExample example);
    long countByExample4(AdminExample example);
    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}