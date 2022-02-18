package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.HisDept;
import com.ruoyi.project.system.service.IHisDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 科室Controller
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@RestController
@RequestMapping("/system/dept")
public class HisDeptController extends BaseController
{
    @Autowired
    private IHisDeptService hisDeptService;

    /**
     * 查询科室列表
     */
    @PreAuthorize("@ss.hasPermi('system:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisDept hisDept)
    {
        startPage();
        List<HisDept> list = hisDeptService.selectHisDeptList(hisDept);
        return getDataTable(list);
    }

    /**
     * 导出科室列表
     */
    @PreAuthorize("@ss.hasPermi('system:dept:export')")
    @Log(title = "科室", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HisDept hisDept)
    {
        List<HisDept> list = hisDeptService.selectHisDeptList(hisDept);
        ExcelUtil<HisDept> util = new ExcelUtil<HisDept>(HisDept.class);
        return util.exportExcel(list, "dept");
    }

    /**
     * 获取科室详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(hisDeptService.selectHisDeptById(deptId));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('system:dept:add')")
    @Log(title = "科室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisDept hisDept)
    {
        return toAjax(hisDeptService.insertHisDept(hisDept));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('system:dept:edit')")
    @Log(title = "科室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisDept hisDept)
    {
        return toAjax(hisDeptService.updateHisDept(hisDept));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('system:dept:remove')")
    @Log(title = "科室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(hisDeptService.deleteHisDeptByIds(deptIds));
    }
}
