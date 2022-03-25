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
import com.ruoyi.kooklen.domain.userAccountManagement;
import com.ruoyi.kooklen.service.IuserAccountManagementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userAccountManagementController
 * 
 * @author kooklen
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/userAccountManagement/userAccountManagement")
public class userAccountManagementController extends BaseController
{
    @Autowired
    private IuserAccountManagementService userAccountManagementService;

    /**
     * 查询userAccountManagement列表
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(userAccountManagement userAccountManagement)
    {
        startPage();
        List<userAccountManagement> list = userAccountManagementService.selectuserAccountManagementList(userAccountManagement);
        return getDataTable(list);
    }

    /**
     * 导出userAccountManagement列表
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:export')")
    @Log(title = "userAccountManagement", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, userAccountManagement userAccountManagement)
    {
        List<userAccountManagement> list = userAccountManagementService.selectuserAccountManagementList(userAccountManagement);
        ExcelUtil<userAccountManagement> util = new ExcelUtil<userAccountManagement>(userAccountManagement.class);
        util.exportExcel(response, list, "userAccountManagement数据");
    }

    /**
     * 获取userAccountManagement详细信息
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:query')")
    @GetMapping(value = "/{userid}")
    public AjaxResult getInfo(@PathVariable("userid") String userid)
    {
        return AjaxResult.success(userAccountManagementService.selectuserAccountManagementByUserid(userid));
    }

    /**
     * 新增userAccountManagement
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:add')")
    @Log(title = "userAccountManagement", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody userAccountManagement userAccountManagement)
    {
        return toAjax(userAccountManagementService.insertuserAccountManagement(userAccountManagement));
    }

    /**
     * 修改userAccountManagement
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:edit')")
    @Log(title = "userAccountManagement", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody userAccountManagement userAccountManagement)
    {
        return toAjax(userAccountManagementService.updateuserAccountManagement(userAccountManagement));
    }

    /**
     * 删除userAccountManagement
     */
    @PreAuthorize("@ss.hasPermi('userAccountManagement:userAccountManagement:remove')")
    @Log(title = "userAccountManagement", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userids}")
    public AjaxResult remove(@PathVariable String[] userids)
    {
        return toAjax(userAccountManagementService.deleteuserAccountManagementByUserids(userids));
    }
}
