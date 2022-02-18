package com.ruoyi.project.hissys.controller;

import java.util.List;
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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.hissys.domain.HisSysDept;
import com.ruoyi.project.hissys.service.IHisSysDeptService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 科室Controller
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@RestController
@RequestMapping("/hissys/dept")
public class HisSysDeptController extends BaseController
{
    @Autowired
    private IHisSysDeptService hisSysDeptService;

    /**
     * 查询科室列表
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisSysDept hisSysDept)
    {
        startPage();
        List<HisSysDept> list = hisSysDeptService.selectHisSysDeptList(hisSysDept);
        return getDataTable(list);
    }

    /**
     * 导出科室列表
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:export')")
    @Log(title = "科室", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HisSysDept hisSysDept)
    {
        List<HisSysDept> list = hisSysDeptService.selectHisSysDeptList(hisSysDept);
        ExcelUtil<HisSysDept> util = new ExcelUtil<HisSysDept>(HisSysDept.class);
        return util.exportExcel(list, "dept");
    }

    /**
     * 获取科室详细信息
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(hisSysDeptService.selectHisSysDeptById(deptId));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:add')")
    @Log(title = "科室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisSysDept hisSysDept)
    {
        return toAjax(hisSysDeptService.insertHisSysDept(hisSysDept));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:edit')")
    @Log(title = "科室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisSysDept hisSysDept)
    {
        return toAjax(hisSysDeptService.updateHisSysDept(hisSysDept));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:remove')")
    @Log(title = "科室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(hisSysDeptService.deleteHisSysDeptByIds(deptIds));
    }
}
