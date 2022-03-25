package com.ruoyi.kooklen.service;

import java.util.List;
import com.ruoyi.kooklen.domain.UserSerarchRecorddd;

/**
 * UserSerarchRecordddService接口
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public interface IUserSerarchRecordddService 
{
    /**
     * 查询UserSerarchRecorddd
     * 
     * @param id UserSerarchRecorddd主键
     * @return UserSerarchRecorddd
     */
    public UserSerarchRecorddd selectUserSerarchRecordddById(Long id);

    /**
     * 查询UserSerarchRecorddd列表
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return UserSerarchRecorddd集合
     */
    public List<UserSerarchRecorddd> selectUserSerarchRecordddList(UserSerarchRecorddd userSerarchRecorddd);

    /**
     * 新增UserSerarchRecorddd
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return 结果
     */
    public int insertUserSerarchRecorddd(UserSerarchRecorddd userSerarchRecorddd);

    /**
     * 修改UserSerarchRecorddd
     * 
     * @param userSerarchRecorddd UserSerarchRecorddd
     * @return 结果
     */
    public int updateUserSerarchRecorddd(UserSerarchRecorddd userSerarchRecorddd);

    /**
     * 批量删除UserSerarchRecorddd
     * 
     * @param ids 需要删除的UserSerarchRecorddd主键集合
     * @return 结果
     */
    public int deleteUserSerarchRecordddByIds(Long[] ids);

    /**
     * 删除UserSerarchRecorddd信息
     * 
     * @param id UserSerarchRecorddd主键
     * @return 结果
     */
    public int deleteUserSerarchRecordddById(Long id);
}
