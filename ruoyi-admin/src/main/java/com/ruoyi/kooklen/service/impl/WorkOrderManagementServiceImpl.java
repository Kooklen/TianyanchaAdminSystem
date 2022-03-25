package com.ruoyi.kooklen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kooklen.mapper.WorkOrderManagementMapper;
import com.ruoyi.kooklen.domain.WorkOrderManagement;
import com.ruoyi.kooklen.service.IWorkOrderManagementService;

/**
 * WorkOrderManagementService业务层处理
 * 
 * @author kooklen
 * @date 2021-12-02
 */
@Service
public class WorkOrderManagementServiceImpl implements IWorkOrderManagementService 
{
    @Autowired
    private WorkOrderManagementMapper workOrderManagementMapper;

    /**
     * 查询WorkOrderManagement
     * 
     * @param id WorkOrderManagement主键
     * @return WorkOrderManagement
     */
    @Override
    public WorkOrderManagement selectWorkOrderManagementById(Long id)
    {
        return workOrderManagementMapper.selectWorkOrderManagementById(id);
    }

    /**
     * 查询WorkOrderManagement列表
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return WorkOrderManagement
     */
    @Override
    public List<WorkOrderManagement> selectWorkOrderManagementList(WorkOrderManagement workOrderManagement)
    {
        return workOrderManagementMapper.selectWorkOrderManagementList(workOrderManagement);
    }

    /**
     * 新增WorkOrderManagement
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return 结果
     */
    @Override
    public int insertWorkOrderManagement(WorkOrderManagement workOrderManagement)
    {
        return workOrderManagementMapper.insertWorkOrderManagement(workOrderManagement);
    }

    /**
     * 修改WorkOrderManagement
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return 结果
     */
    @Override
    public int updateWorkOrderManagement(WorkOrderManagement workOrderManagement)
    {
        return workOrderManagementMapper.updateWorkOrderManagement(workOrderManagement);
    }

    /**
     * 批量删除WorkOrderManagement
     * 
     * @param ids 需要删除的WorkOrderManagement主键
     * @return 结果
     */
    @Override
    public int deleteWorkOrderManagementByIds(Long[] ids)
    {
        return workOrderManagementMapper.deleteWorkOrderManagementByIds(ids);
    }

    /**
     * 删除WorkOrderManagement信息
     * 
     * @param id WorkOrderManagement主键
     * @return 结果
     */
    @Override
    public int deleteWorkOrderManagementById(Long id)
    {
        return workOrderManagementMapper.deleteWorkOrderManagementById(id);
    }
}
