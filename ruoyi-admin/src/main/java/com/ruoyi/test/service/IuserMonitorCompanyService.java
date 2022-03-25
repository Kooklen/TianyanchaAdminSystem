package com.ruoyi.test.service;

import java.util.List;
import com.ruoyi.test.domain.userMonitorCompany;

/**
 * userMonitorCompanyService接口
 * 
 * @author kooklen
 * @date 2021-12-28
 */
public interface IuserMonitorCompanyService 
{
    /**
     * 查询userMonitorCompany
     * 
     * @param recordnumber userMonitorCompany主键
     * @return userMonitorCompany
     */
    public userMonitorCompany selectuserMonitorCompanyByRecordnumber(Long recordnumber);

    /**
     * 查询userMonitorCompany列表
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return userMonitorCompany集合
     */
    public List<userMonitorCompany> selectuserMonitorCompanyList(userMonitorCompany userMonitorCompany);

    /**
     * 新增userMonitorCompany
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return 结果
     */
    public int insertuserMonitorCompany(userMonitorCompany userMonitorCompany);

    /**
     * 修改userMonitorCompany
     * 
     * @param userMonitorCompany userMonitorCompany
     * @return 结果
     */
    public int updateuserMonitorCompany(userMonitorCompany userMonitorCompany);

    /**
     * 批量删除userMonitorCompany
     * 
     * @param recordnumbers 需要删除的userMonitorCompany主键集合
     * @return 结果
     */
    public int deleteuserMonitorCompanyByRecordnumbers(Long[] recordnumbers);

    /**
     * 删除userMonitorCompany信息
     * 
     * @param recordnumber userMonitorCompany主键
     * @return 结果
     */
    public int deleteuserMonitorCompanyByRecordnumber(Long recordnumber);
}
