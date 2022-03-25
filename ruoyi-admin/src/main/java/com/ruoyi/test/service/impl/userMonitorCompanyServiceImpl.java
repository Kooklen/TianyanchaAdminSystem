package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.userMonitorCompanyMapper;
import com.ruoyi.test.domain.userMonitorCompany;
import com.ruoyi.test.service.IuserMonitorCompanyService;

/**
 * userMonitorCompanyService业务层处理
 * 
 * @author kooklen
 * @date 2021-12-28
 */
@Service
public class userMonitorCompanyServiceImpl implements IuserMonitorCompanyService 
{
    @Autowired
    private userMonitorCompanyMapper userMonitorCompanyMapper;

    /**
     * 查询userMonitorCompany
     * 
     * @param recordnumber userMonitorCompany主键
     * @return userMonitorCompany
     */
    @Override
    public userMonitorCompany selectuserMonitorCompanyByRecordnumber(Long recordnumber)
    {
        return userMonitorCompanyMapper.selectuserMonitorCompanyByRecordnumber(recordnumber);
    }

    /**
     * 查询userMonitorCompany列表
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return userMonitorCompany
     */
    @Override
    public List<userMonitorCompany> selectuserMonitorCompanyList(userMonitorCompany userMonitorCompany)
    {
        return userMonitorCompanyMapper.selectuserMonitorCompanyList(userMonitorCompany);
    }

    /**
     * 新增userMonitorCompany
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return 结果
     */
    @Override
    public int insertuserMonitorCompany(userMonitorCompany userMonitorCompany)
    {
        return userMonitorCompanyMapper.insertuserMonitorCompany(userMonitorCompany);
    }

    /**
     * 修改userMonitorCompany
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return 结果
     */
    @Override
    public int updateuserMonitorCompany(userMonitorCompany userMonitorCompany)
    {
        return userMonitorCompanyMapper.updateuserMonitorCompany(userMonitorCompany);
    }

    /**
     * 批量删除userMonitorCompany
     * 
     * @param recordnumbers 需要删除的userMonitorCompany主键
     * @return 结果
     */
    @Override
    public int deleteuserMonitorCompanyByRecordnumbers(Long[] recordnumbers)
    {
        return userMonitorCompanyMapper.deleteuserMonitorCompanyByRecordnumbers(recordnumbers);
    }

    /**
     * 删除userMonitorCompany信息
     * 
     * @param recordnumber userMonitorCompany主键
     * @return 结果
     */
    @Override
    public int deleteuserMonitorCompanyByRecordnumber(Long recordnumber)
    {
        return userMonitorCompanyMapper.deleteuserMonitorCompanyByRecordnumber(recordnumber);
    }
}
