package com.ruoyi.project.hissys.mapper;

import java.util.List;
import com.ruoyi.project.hissys.domain.HisSysDept;

/**
 * 科室Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
public interface HisSysDeptMapper 
{
    /**
     * 查询科室
     * 
     * @param deptId 科室ID
     * @return 科室
     */
    public HisSysDept selectHisSysDeptById(Long deptId);

    /**
     * 查询科室列表
     * 
     * @param hisSysDept 科室
     * @return 科室集合
     */
    public List<HisSysDept> selectHisSysDeptList(HisSysDept hisSysDept);

    /**
     * 新增科室
     * 
     * @param hisSysDept 科室
     * @return 结果
     */
    public int insertHisSysDept(HisSysDept hisSysDept);

    /**
     * 修改科室
     * 
     * @param hisSysDept 科室
     * @return 结果
     */
    public int updateHisSysDept(HisSysDept hisSysDept);

    /**
     * 删除科室
     * 
     * @param deptId 科室ID
     * @return 结果
     */
    public int deleteHisSysDeptById(Long deptId);

    /**
     * 批量删除科室
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHisSysDeptByIds(Long[] deptIds);
}
