package com.ruoyi.kooklen.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Excel;
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
import com.ruoyi.kooklen.domain.UserSearchRecord;
import com.ruoyi.kooklen.service.IUserSearchRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户搜索记录Controller
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@RestController
@RequestMapping("/userSearchRecord/userSearchRecord")
public class UserSearchRecordController extends BaseController
{
    @Autowired
    private IUserSearchRecordService userSearchRecordService;

    /**
     * 查询用户搜索记录列表
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserSearchRecord userSearchRecord)
    {
        startPage();
        List<UserSearchRecord> list = userSearchRecordService.selectUserSearchRecordList(userSearchRecord);
        return getDataTable(list);
    }

    /**
     * 导出用户搜索记录列表
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:export')")
    @Log(title = "用户搜索记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserSearchRecord userSearchRecord)
    {
        List<UserSearchRecord> list = userSearchRecordService.selectUserSearchRecordList(userSearchRecord);
        ExcelUtil<UserSearchRecord> util = new ExcelUtil<UserSearchRecord>(UserSearchRecord.class);
        util.exportExcel(response, list, "用户搜索记录数据");
    }

    /**
     * 获取用户搜索记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:query')")
    @GetMapping(value = "/{recordnumber}")
    public AjaxResult getInfo(@PathVariable("recordnumber") Long recordnumber)
    {
        return AjaxResult.success(userSearchRecordService.selectUserSearchRecordByRecordnumber(recordnumber));
    }

    /**
     * 新增用户搜索记录
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:add')")
    @Log(title = "用户搜索记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserSearchRecord userSearchRecord)
    {
        return toAjax(userSearchRecordService.insertUserSearchRecord(userSearchRecord));
    }

    /**
     * 修改用户搜索记录
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:edit')")
    @Log(title = "用户搜索记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserSearchRecord userSearchRecord)
    {
        return toAjax(userSearchRecordService.updateUserSearchRecord(userSearchRecord));
    }

    /**
     * 删除用户搜索记录
     */
    @PreAuthorize("@ss.hasPermi('userSearchRecord:userSearchRecord:remove')")
    @Log(title = "用户搜索记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordnumbers}")
    public AjaxResult remove(@PathVariable Long[] recordnumbers)
    {
        return toAjax(userSearchRecordService.deleteUserSearchRecordByRecordnumbers(recordnumbers));
    }
}
