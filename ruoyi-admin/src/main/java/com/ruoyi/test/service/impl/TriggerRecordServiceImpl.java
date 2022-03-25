package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.TriggerRecordMapper;
import com.ruoyi.test.domain.TriggerRecord;
import com.ruoyi.test.service.ITriggerRecordService;

/**
 * userTriggerRecordService业务层处理
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@Service
public class TriggerRecordServiceImpl implements ITriggerRecordService 
{
    @Autowired
    private TriggerRecordMapper triggerRecordMapper;

    /**
     * 查询userTriggerRecord
     * 
     * @param recordnumber userTriggerRecord主键
     * @return userTriggerRecord
     */
    @Override
    public TriggerRecord selectTriggerRecordByRecordnumber(Long recordnumber)
    {
        return triggerRecordMapper.selectTriggerRecordByRecordnumber(recordnumber);
    }

    /**
     * 查询userTriggerRecord列表
     * 
     * @param triggerRecord userTriggerRecord
     * @return userTriggerRecord
     */
    @Override
    public List<TriggerRecord> selectTriggerRecordList(TriggerRecord triggerRecord)
    {
        return triggerRecordMapper.selectTriggerRecordList(triggerRecord);
    }

    /**
     * 新增userTriggerRecord
     * 
     * @param triggerRecord userTriggerRecord
     * @return 结果
     */
    @Override
    public int insertTriggerRecord(TriggerRecord triggerRecord)
    {
        return triggerRecordMapper.insertTriggerRecord(triggerRecord);
    }

    /**
     * 修改userTriggerRecord
     * 
     * @param triggerRecord userTriggerRecord
     * @return 结果
     */
    @Override
    public int updateTriggerRecord(TriggerRecord triggerRecord)
    {
        return triggerRecordMapper.updateTriggerRecord(triggerRecord);
    }

    /**
     * 批量删除userTriggerRecord
     * 
     * @param recordnumbers 需要删除的userTriggerRecord主键
     * @return 结果
     */
    @Override
    public int deleteTriggerRecordByRecordnumbers(Long[] recordnumbers)
    {
        return triggerRecordMapper.deleteTriggerRecordByRecordnumbers(recordnumbers);
    }

    /**
     * 删除userTriggerRecord信息
     * 
     * @param recordnumber userTriggerRecord主键
     * @return 结果
     */
    @Override
    public int deleteTriggerRecordByRecordnumber(Long recordnumber)
    {
        return triggerRecordMapper.deleteTriggerRecordByRecordnumber(recordnumber);
    }
}
