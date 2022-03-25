package com.ruoyi.kooklen.service;

import java.util.List;
import com.ruoyi.kooklen.domain.UserSearchRecord;

/**
 * 用户搜索记录Service接口
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public interface IUserSearchRecordService 
{
    /**
     * 查询用户搜索记录
     * 
     * @param recordnumber 用户搜索记录主键
     * @return 用户搜索记录
     */
    public UserSearchRecord selectUserSearchRecordByRecordnumber(Long recordnumber);

    /**
     * 查询用户搜索记录列表
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 用户搜索记录集合
     */
    public List<UserSearchRecord> selectUserSearchRecordList(UserSearchRecord userSearchRecord);

    /**
     * 新增用户搜索记录
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 结果
     */
    public int insertUserSearchRecord(UserSearchRecord userSearchRecord);

    /**
     * 修改用户搜索记录
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 结果
     */
    public int updateUserSearchRecord(UserSearchRecord userSearchRecord);

    /**
     * 批量删除用户搜索记录
     * 
     * @param recordnumbers 需要删除的用户搜索记录主键集合
     * @return 结果
     */
    public int deleteUserSearchRecordByRecordnumbers(Long[] recordnumbers);

    /**
     * 删除用户搜索记录信息
     * 
     * @param recordnumber 用户搜索记录主键
     * @return 结果
     */
    public int deleteUserSearchRecordByRecordnumber(Long recordnumber);
}
