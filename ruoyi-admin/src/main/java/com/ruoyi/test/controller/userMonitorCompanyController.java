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
import com.ruoyi.test.domain.userMonitorCompany;
import com.ruoyi.test.service.IuserMonitorCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userMonitorCompanyController
 * 
 * @author kooklen
 * @date 2021-12-28
 */
@RestController
@RequestMapping("/userMonitorCompany/userMonitorCompany")
public class userMonitorCompanyController extends BaseController
{
    @Autowired
    private IuserMonitorCompanyService userMonitorCompanyService;

    /**
     * 查询userMonitorCompany列表
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:list')")
    @GetMapping("/list")
    public TableDataInfo list(userMonitorCompany userMonitorCompany)
    {
        startPage();
        List<userMonitorCompany> list = userMonitorCompanyService.selectuserMonitorCompanyList(userMonitorCompany);
        return getDataTable(list);
    }

    /**
     * 导出userMonitorCompany列表
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:export')")
    @Log(title = "userMonitorCompany", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, userMonitorCompany userMonitorCompany)
    {
        List<userMonitorCompany> list = userMonitorCompanyService.selectuserMonitorCompanyList(userMonitorCompany);
        ExcelUtil<userMonitorCompany> util = new ExcelUtil<userMonitorCompany>(userMonitorCompany.class);
        util.exportExcel(response, list, "userMonitorCompany数据");
    }

    /**
     * 获取userMonitorCompany详细信息
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:query')")
    @GetMapping(value = "/{recordnumber}")
    public AjaxResult getInfo(@PathVariable("recordnumber") Long recordnumber)
    {
        return AjaxResult.success(userMonitorCompanyService.selectuserMonitorCompanyByRecordnumber(recordnumber));
    }

    /**
     * 新增userMonitorCompany
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:add')")
    @Log(title = "userMonitorCompany", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody userMonitorCompany userMonitorCompany)
    {
        return toAjax(userMonitorCompanyService.insertuserMonitorCompany(userMonitorCompany));
    }

    /**
     * 修改userMonitorCompany
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:edit')")
    @Log(title = "userMonitorCompany", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody userMonitorCompany userMonitorCompany)
    {
        return toAjax(userMonitorCompanyService.updateuserMonitorCompany(userMonitorCompany));
    }

    /**
     * 删除userMonitorCompany
     */
    @PreAuthorize("@ss.hasPermi('userMonitorCompany:userMonitorCompany:remove')")
    @Log(title = "userMonitorCompany", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordnumbers}")
    public AjaxResult remove(@PathVariable Long[] recordnumbers)
    {
        return toAjax(userMonitorCompanyService.deleteuserMonitorCompanyByRecordnumbers(recordnumbers));
    }
}
