package com.ruoyi.kooklen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kooklen.mapper.UserSerarchRecordddMapper;
import com.ruoyi.kooklen.domain.UserSerarchRecorddd;
import com.ruoyi.kooklen.service.IUserSerarchRecordddService;

/**
 * UserSerarchRecordddService业务层处理
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@Service
public class UserSerarchRecordddServiceImpl implements IUserSerarchRecordddService 
{
    @Autowired
    private UserSerarchRecordddMapper userSerarchRecordddMapper;

    /**
     * 查询UserSerarchRecorddd
     * 
     * @param id UserSerarchRecorddd主键
     * @return UserSerarchRecorddd
     */
    @Override
    public UserSerarchRecorddd selectUserSerarchRecordddById(Long id)
    {
        return userSerarchRecordddMapper.selectUserSerarchRecordddById(id);
    }

    /**
     * 查询UserSerarchRecorddd列表
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return UserSerarchRecorddd
     */
    @Override
    public List<UserSerarchRecorddd> selectUserSerarchRecordddList(UserSerarchRecorddd userSerarchRecorddd)
    {
        return userSerarchRecordddMapper.selectUserSerarchRecordddList(userSerarchRecorddd);
    }

    /**
     * 新增UserSerarchRecorddd
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return 结果
     */
    @Override
    public int insertUserSerarchRecorddd(UserSerarchRecorddd userSerarchRecorddd)
    {
        return userSerarchRecordddMapper.insertUserSerarchRecorddd(userSerarchRecorddd);
    }

    /**
     * 修改UserSerarchRecorddd
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return 结果
     */
    @Override
    public int updateUserSerarchRecorddd(UserSerarchRecorddd userSerarchRecorddd)
    {
        return userSerarchRecordddMapper.updateUserSerarchRecorddd(userSerarchRecorddd);
    }

    /**
     * 批量删除UserSerarchRecorddd
     * 
     * @param ids 需要删除的UserSerarchRecorddd主键
     * @return 结果
     */
    @Override
    public int deleteUserSerarchRecordddByIds(Long[] ids)
    {
        return userSerarchRecordddMapper.deleteUserSerarchRecordddByIds(ids);
    }

    /**
     * 删除UserSerarchRecorddd信息
     * 
     * @param id UserSerarchRecorddd主键
     * @return 结果
     */
    @Override
    public int deleteUserSerarchRecordddById(Long id)
    {
        return userSerarchRecordddMapper.deleteUserSerarchRecordddById(id);
    }
}
