package com.ruoyi.kooklen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kooklen.mapper.UserSearchRecordMapper;
import com.ruoyi.kooklen.domain.UserSearchRecord;
import com.ruoyi.kooklen.service.IUserSearchRecordService;

/**
 * 用户搜索记录Service业务层处理
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@Service
public class UserSearchRecordServiceImpl implements IUserSearchRecordService 
{
    @Autowired
    private UserSearchRecordMapper userSearchRecordMapper;

    /**
     * 查询用户搜索记录
     * 
     * @param recordnumber 用户搜索记录主键
     * @return 用户搜索记录
     */
    @Override
    public UserSearchRecord selectUserSearchRecordByRecordnumber(Long recordnumber)
    {
        return userSearchRecordMapper.selectUserSearchRecordByRecordnumber(recordnumber);
    }

    /**
     * 查询用户搜索记录列表
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 用户搜索记录
     */
    @Override
    public List<UserSearchRecord> selectUserSearchRecordList(UserSearchRecord userSearchRecord)
    {
        return userSearchRecordMapper.selectUserSearchRecordList(userSearchRecord);
    }

    /**
     * 新增用户搜索记录
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 结果
     */
    @Override
    public int insertUserSearchRecord(UserSearchRecord userSearchRecord)
    {
        return userSearchRecordMapper.insertUserSearchRecord(userSearchRecord);
    }

    /**
     * 修改用户搜索记录
     * 
     * @param userSearchRecord 用户搜索记录
     * @return 结果
     */
    @Override
    public int updateUserSearchRecord(UserSearchRecord userSearchRecord)
    {
        return userSearchRecordMapper.updateUserSearchRecord(userSearchRecord);
    }

    /**
     * 批量删除用户搜索记录
     * 
     * @param recordnumbers 需要删除的用户搜索记录主键
     * @return 结果
     */
    @Override
    public int deleteUserSearchRecordByRecordnumbers(Long[] recordnumbers)
    {
        return userSearchRecordMapper.deleteUserSearchRecordByRecordnumbers(recordnumbers);
    }

    /**
     * 删除用户搜索记录信息
     * 
     * @param recordnumber 用户搜索记录主键
     * @return 结果
     */
    @Override
    public int deleteUserSearchRecordByRecordnumber(Long recordnumber)
    {
        return userSearchRecordMapper.deleteUserSearchRecordByRecordnumber(recordnumber);
    }
}
