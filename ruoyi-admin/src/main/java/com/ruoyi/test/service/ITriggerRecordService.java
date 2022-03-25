package com.ruoyi.test.service;

import java.util.List;
import com.ruoyi.test.domain.TriggerRecord;

/**
 * userTriggerRecordService接口
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public interface ITriggerRecordService 
{
    /**
     * 查询userTriggerRecord
     * 
     * @param recordnumber userTriggerRecord主键
     * @return userTriggerRecord
     */
    public TriggerRecord selectTriggerRecordByRecordnumber(Long recordnumber);

    /**
     * 查询userTriggerRecord列表
     * 
     * @param triggerRecord userTriggerRecord
     * @return userTriggerRecord集合
     */
    public List<TriggerRecord> selectTriggerRecordList(TriggerRecord triggerRecord);

    /**
     * 新增userTriggerRecord
     * 
     * @param triggerRecord userTriggerRecord
     * @return 结果
     */
    public int insertTriggerRecord(TriggerRecord triggerRecord);

    /**
     * 修改userTriggerRecord
     * 
     * @param triggerRecord userTriggerRecord
     * @return 结果
     */
    public int updateTriggerRecord(TriggerRecord triggerRecord);

    /**
     * 批量删除userTriggerRecord
     * 
     * @param recordnumbers 需要删除的userTriggerRecord主键集合
     * @return 结果
     */
    public int deleteTriggerRecordByRecordnumbers(Long[] recordnumbers);

    /**
     * 删除userTriggerRecord信息
     * 
     * @param recordnumber userTriggerRecord主键
     * @return 结果
     */
    public int deleteTriggerRecordByRecordnumber(Long recordnumber);
}
