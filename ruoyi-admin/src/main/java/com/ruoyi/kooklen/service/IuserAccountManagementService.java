package com.ruoyi.kooklen.service;

import java.util.List;
import com.ruoyi.kooklen.domain.userAccountManagement;

/**
 * userAccountManagementService接口
 * 
 * @author kooklen
 * @date 2021-12-01
 */
public interface IuserAccountManagementService 
{
    /**
     * 查询userAccountManagement
     * 
     * @param userid userAccountManagement主键
     * @return userAccountManagement
     */
    public userAccountManagement selectuserAccountManagementByUserid(String userid);

    /**
     * 查询userAccountManagement列表
     * 
     * @param userAccountManagement userAccountManagement
     * @return userAccountManagement集合
     */
    public List<userAccountManagement> selectuserAccountManagementList(userAccountManagement userAccountManagement);

    /**
     * 新增userAccountManagement
     * 
     * @param userAccountManagement userAccountManagement
     * @return 结果
     */
    public int insertuserAccountManagement(userAccountManagement userAccountManagement);

    /**
     * 修改userAccountManagement
     * 
     * @param userAccountManagement userAccountManagement
     * @return 结果
     */
    public int updateuserAccountManagement(userAccountManagement userAccountManagement);

    /**
     * 批量删除userAccountManagement
     * 
     * @param userids 需要删除的userAccountManagement主键集合
     * @return 结果
     */
    public int deleteuserAccountManagementByUserids(String[] userids);

    /**
     * 删除userAccountManagement信息
     * 
     * @param userid userAccountManagement主键
     * @return 结果
     */
    public int deleteuserAccountManagementByUserid(String userid);
}
