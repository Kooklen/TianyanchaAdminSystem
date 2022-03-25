package com.ruoyi.kooklen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kooklen.mapper.userAccountManagementMapper;
import com.ruoyi.kooklen.domain.userAccountManagement;
import com.ruoyi.kooklen.service.IuserAccountManagementService;

/**
 * userAccountManagementService业务层处理
 * 
 * @author kooklen
 * @date 2021-12-01
 */
@Service
public class userAccountManagementServiceImpl implements IuserAccountManagementService 
{
    @Autowired
    private userAccountManagementMapper userAccountManagementMapper;

    /**
     * 查询userAccountManagement
     * 
     * @param userid userAccountManagement主键
     * @return userAccountManagement
     */
    @Override
    public userAccountManagement selectuserAccountManagementByUserid(String userid)
    {
        return userAccountManagementMapper.selectuserAccountManagementByUserid(userid);
    }

    /**
     * 查询userAccountManagement列表
     * 
     * @param userAccountManagement userAccountManagement
     * @return userAccountManagement
     */
    @Override
    public List<userAccountManagement> selectuserAccountManagementList(userAccountManagement userAccountManagement)
    {
        return userAccountManagementMapper.selectuserAccountManagementList(userAccountManagement);
    }

    /**
     * 新增userAccountManagement
     * 
     * @param userAccountManagement userAccountManagement
     * @return 结果
     */
    @Override
    public int insertuserAccountManagement(userAccountManagement userAccountManagement)
    {
        return userAccountManagementMapper.insertuserAccountManagement(userAccountManagement);
    }

    /**
     * 修改userAccountManagement
     * 
     * @param userAccountManagement userAccountManagement
     * @return 结果
     */
    @Override
    public int updateuserAccountManagement(userAccountManagement userAccountManagement)
    {
        return userAccountManagementMapper.updateuserAccountManagement(userAccountManagement);
    }

    /**
     * 批量删除userAccountManagement
     * 
     * @param userids 需要删除的userAccountManagement主键
     * @return 结果
     */
    @Override
    public int deleteuserAccountManagementByUserids(String[] userids)
    {
        return userAccountManagementMapper.deleteuserAccountManagementByUserids(userids);
    }

    /**
     * 删除userAccountManagement信息
     * 
     * @param userid userAccountManagement主键
     * @return 结果
     */
    @Override
    public int deleteuserAccountManagementByUserid(String userid)
    {
        return userAccountManagementMapper.deleteuserAccountManagementByUserid(userid);
    }
}
