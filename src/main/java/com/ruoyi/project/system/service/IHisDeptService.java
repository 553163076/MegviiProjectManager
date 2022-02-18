package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.HisDept;

import java.util.List;

/**
 * 科室Service接口
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
public interface IHisDeptService 
{
    /**
     * 查询科室
     * 
     * @param deptId 科室ID
     * @return 科室
     */
    public HisDept selectHisDeptById(Long deptId);

    /**
     * 查询科室列表
     * 
     * @param hisDept 科室
     * @return 科室集合
     */
    public List<HisDept> selectHisDeptList(HisDept hisDept);

    /**
     * 新增科室
     * 
     * @param hisDept 科室
     * @return 结果
     */
    public int insertHisDept(HisDept hisDept);

    /**
     * 修改科室
     * 
     * @param hisDept 科室
     * @return 结果
     */
    public int updateHisDept(HisDept hisDept);

    /**
     * 批量删除科室
     * 
     * @param deptIds 需要删除的科室ID
     * @return 结果
     */
    public int deleteHisDeptByIds(Long[] deptIds);

    /**
     * 删除科室信息
     * 
     * @param deptId 科室ID
     * @return 结果
     */
    public int deleteHisDeptById(Long deptId);
}
