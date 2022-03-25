package com.ruoyi.kooklen.mapper;

import java.util.List;
import com.ruoyi.kooklen.domain.userAccountManagement;

/**
 * userAccountManagementMapper接口
 * 
 * @author kooklen
 * @date 2021-12-01
 */
public interface userAccountManagementMapper 
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
     * 删除userAccountManagement
     * 
     * @param userid userAccountManagement主键
     * @return 结果
     */
    public int deleteuserAccountManagementByUserid(String userid);

    /**
     * 批量删除userAccountManagement
     * 
     * @param userids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteuserAccountManagementByUserids(String[] userids);
}
