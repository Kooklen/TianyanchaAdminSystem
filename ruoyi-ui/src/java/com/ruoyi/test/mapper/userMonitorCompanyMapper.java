package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.userMonitorCompany;

/**
 * userMonitorCompanyMapper接口
 *
 * @author kooklen
 * @date 2021-11-30
 */
public interface userMonitorCompanyMapper
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
     * 删除userMonitorCompany
     *
     * @param recordnumber userMonitorCompany主键
     * @return 结果
     */
    public int deleteuserMonitorCompanyByRecordnumber(Long recordnumber);

    /**
     * 批量删除userMonitorCompany
     *
     * @param recordnumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteuserMonitorCompanyByRecordnumbers(Long[] recordnumbers);
}
