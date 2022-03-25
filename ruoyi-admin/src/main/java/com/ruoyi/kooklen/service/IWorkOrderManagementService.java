package com.ruoyi.kooklen.service;

import java.util.List;
import com.ruoyi.kooklen.domain.WorkOrderManagement;

/**
 * WorkOrderManagementService接口
 * 
 * @author kooklen
 * @date 2021-12-02
 */
public interface IWorkOrderManagementService 
{
    /**
     * 查询WorkOrderManagement
     * 
     * @param id WorkOrderManagement主键
     * @return WorkOrderManagement
     */
    public WorkOrderManagement selectWorkOrderManagementById(Long id);

    /**
     * 查询WorkOrderManagement列表
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return WorkOrderManagement集合
     */
    public List<WorkOrderManagement> selectWorkOrderManagementList(WorkOrderManagement workOrderManagement);

    /**
     * 新增WorkOrderManagement
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return 结果
     */
    public int insertWorkOrderManagement(WorkOrderManagement workOrderManagement);

    /**
     * 修改WorkOrderManagement
     * 
     * @param workOrderManagement WorkOrderManagement
     * @return 结果
     */
    public int updateWorkOrderManagement(WorkOrderManagement workOrderManagement);

    /**
     * 批量删除WorkOrderManagement
     * 
     * @param ids 需要删除的WorkOrderManagement主键集合
     * @return 结果
     */
    public int deleteWorkOrderManagementByIds(Long[] ids);

    /**
     * 删除WorkOrderManagement信息
     * 
     * @param id WorkOrderManagement主键
     * @return 结果
     */
    public int deleteWorkOrderManagementById(Long id);
}
