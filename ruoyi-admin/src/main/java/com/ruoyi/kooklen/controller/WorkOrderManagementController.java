package com.ruoyi.kooklen.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.kooklen.domain.WorkOrderManagement;
import com.ruoyi.kooklen.service.IWorkOrderManagementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * WorkOrderManagementController
 * 
 * @author kooklen
 * @date 2021-12-02
 */
@RestController
@RequestMapping("/WorkOrderManagement/WorkOrderManagement")
public class WorkOrderManagementController extends BaseController
{
    @Autowired
    private IWorkOrderManagementService workOrderManagementService;

    /**
     * 查询WorkOrderManagement列表
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(WorkOrderManagement workOrderManagement)
    {
        startPage();
        List<WorkOrderManagement> list = workOrderManagementService.selectWorkOrderManagementList(workOrderManagement);
        return getDataTable(list);
    }

    /**
     * 导出WorkOrderManagement列表
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:export')")
    @Log(title = "WorkOrderManagement", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WorkOrderManagement workOrderManagement)
    {
        List<WorkOrderManagement> list = workOrderManagementService.selectWorkOrderManagementList(workOrderManagement);
        ExcelUtil<WorkOrderManagement> util = new ExcelUtil<WorkOrderManagement>(WorkOrderManagement.class);
        util.exportExcel(response, list, "WorkOrderManagement数据");
    }

    /**
     * 获取WorkOrderManagement详细信息
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(workOrderManagementService.selectWorkOrderManagementById(id));
    }

    /**
     * 新增WorkOrderManagement
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:add')")
    @Log(title = "WorkOrderManagement", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WorkOrderManagement workOrderManagement)
    {
        return toAjax(workOrderManagementService.insertWorkOrderManagement(workOrderManagement));
    }

    /**
     * 修改WorkOrderManagement
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:edit')")
    @Log(title = "WorkOrderManagement", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WorkOrderManagement workOrderManagement)
    {
        return toAjax(workOrderManagementService.updateWorkOrderManagement(workOrderManagement));
    }

    /**
     * 删除WorkOrderManagement
     */
    @PreAuthorize("@ss.hasPermi('WorkOrderManagement:WorkOrderManagement:remove')")
    @Log(title = "WorkOrderManagement", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(workOrderManagementService.deleteWorkOrderManagementByIds(ids));
    }
}
