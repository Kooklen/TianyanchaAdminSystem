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
import com.ruoyi.kooklen.domain.UserSerarchRecorddd;
import com.ruoyi.kooklen.service.IUserSerarchRecordddService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * UserSerarchRecordddController
 * 
 * @author kooklen
 * @date 2021-12-03
 */
@RestController
@RequestMapping("/UserSerarchRecorddd/UserSerarchRecorddd")
public class UserSerarchRecordddController extends BaseController
{
    @Autowired
    private IUserSerarchRecordddService userSerarchRecordddService;

    /**
     * 查询UserSerarchRecorddd列表
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserSerarchRecorddd userSerarchRecorddd)
    {
        startPage();
        List<UserSerarchRecorddd> list = userSerarchRecordddService.selectUserSerarchRecordddList(userSerarchRecorddd);
        return getDataTable(list);
    }

    /**
     * 导出UserSerarchRecorddd列表
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:export')")
    @Log(title = "UserSerarchRecorddd", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserSerarchRecorddd userSerarchRecorddd)
    {
        List<UserSerarchRecorddd> list = userSerarchRecordddService.selectUserSerarchRecordddList(userSerarchRecorddd);
        ExcelUtil<UserSerarchRecorddd> util = new ExcelUtil<UserSerarchRecorddd>(UserSerarchRecorddd.class);
        util.exportExcel(response, list, "UserSerarchRecorddd数据");
    }

    /**
     * 获取UserSerarchRecorddd详细信息
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userSerarchRecordddService.selectUserSerarchRecordddById(id));
    }

    /**
     * 新增UserSerarchRecorddd
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:add')")
    @Log(title = "UserSerarchRecorddd", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserSerarchRecorddd userSerarchRecorddd)
    {
        return toAjax(userSerarchRecordddService.insertUserSerarchRecorddd(userSerarchRecorddd));
    }

    /**
     * 修改UserSerarchRecorddd
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:edit')")
    @Log(title = "UserSerarchRecorddd", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserSerarchRecorddd userSerarchRecorddd)
    {
        return toAjax(userSerarchRecordddService.updateUserSerarchRecorddd(userSerarchRecorddd));
    }

    /**
     * 删除UserSerarchRecorddd
     */
    @PreAuthorize("@ss.hasPermi('UserSerarchRecorddd:UserSerarchRecorddd:remove')")
    @Log(title = "UserSerarchRecorddd", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userSerarchRecordddService.deleteUserSerarchRecordddByIds(ids));
    }
}
