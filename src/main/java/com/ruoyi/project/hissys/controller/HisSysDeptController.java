package com.ruoyi.project.hissys.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.hissys.domain.HisSysDept;
import com.ruoyi.project.hissys.service.IHisSysDeptService;
import com.ruoyi.project.system.domain.SysPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hissys/dept")
public class HisSysDeptController extends BaseController {
    @Autowired
    private IHisSysDeptService deptService;

    @Log(title = "科室管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('hissys:dept:export')")
    @GetMapping("/export")
    public AjaxResult export(HisSysDept dept)
    {
        List<HisSysDept> list = deptService.selectDeptList(dept);
        ExcelUtil<HisSysDept> util = new ExcelUtil<HisSysDept>(HisSysDept.class);
        return util.exportExcel(list, "科室数据");
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:remove')")
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(deptService.deleteDeptByIds(deptIds));
    }

    /**
     * 根据科室ID获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId)
    {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 更新科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:edit')")
    @Log(title = "科室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody HisSysDept dept)
    {
        // 设置登录用户名，就是更新者名称
        dept.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:add')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody HisSysDept dept)
    {
        // 新增的科室，和已有的科室，名称不能相同
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return AjaxResult.error("新增科室'" + dept.getDeptName() + "'失败，科室名称已存在");
        }
        // 设置登录用户名，就是创建者名称
        dept.setCreateBy(SecurityUtils.getUsername());
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 获取岗位列表
     */
    @PreAuthorize("@ss.hasPermi('hissys:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisSysDept dept)
    {
        startPage();
        List<HisSysDept> list = deptService.selectDeptList(dept);
        return getDataTable(list);
    }
}
