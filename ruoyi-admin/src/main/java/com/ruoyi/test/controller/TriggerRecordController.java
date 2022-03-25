package com.ruoyi.test.controller;

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
import com.ruoyi.test.domain.TriggerRecord;
import com.ruoyi.test.service.ITriggerRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userTriggerRecordController
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@RestController
@RequestMapping("/userTriggerRecord/userTriggerRecord")
public class TriggerRecordController extends BaseController
{
    @Autowired
    private ITriggerRecordService triggerRecordService;

    /**
     * 查询userTriggerRecord列表
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TriggerRecord triggerRecord)
    {
        startPage();
        List<TriggerRecord> list = triggerRecordService.selectTriggerRecordList(triggerRecord);
        return getDataTable(list);
    }

    /**
     * 导出userTriggerRecord列表
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:export')")
    @Log(title = "userTriggerRecord", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TriggerRecord triggerRecord)
    {
        List<TriggerRecord> list = triggerRecordService.selectTriggerRecordList(triggerRecord);
        ExcelUtil<TriggerRecord> util = new ExcelUtil<TriggerRecord>(TriggerRecord.class);
        util.exportExcel(response, list, "userTriggerRecord数据");
    }

    /**
     * 获取userTriggerRecord详细信息
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:query')")
    @GetMapping(value = "/{recordnumber}")
    public AjaxResult getInfo(@PathVariable("recordnumber") Long recordnumber)
    {
        return AjaxResult.success(triggerRecordService.selectTriggerRecordByRecordnumber(recordnumber));
    }

    /**
     * 新增userTriggerRecord
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:add')")
    @Log(title = "userTriggerRecord", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TriggerRecord triggerRecord)
    {
        return toAjax(triggerRecordService.insertTriggerRecord(triggerRecord));
    }

    /**
     * 修改userTriggerRecord
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:edit')")
    @Log(title = "userTriggerRecord", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TriggerRecord triggerRecord)
    {
        return toAjax(triggerRecordService.updateTriggerRecord(triggerRecord));
    }

    /**
     * 删除userTriggerRecord
     */
    @PreAuthorize("@ss.hasPermi('userTriggerRecord:userTriggerRecord:remove')")
    @Log(title = "userTriggerRecord", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordnumbers}")
    public AjaxResult remove(@PathVariable Long[] recordnumbers)
    {
        return toAjax(triggerRecordService.deleteTriggerRecordByRecordnumbers(recordnumbers));
    }
}
