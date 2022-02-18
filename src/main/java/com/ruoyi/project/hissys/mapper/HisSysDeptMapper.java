package com.ruoyi.project.hissys.mapper;

import com.ruoyi.project.hissys.domain.HisSysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HisSysDeptMapper {
    /**
     * 分页查询科室
     * @param dept
     * @return
     */
    List<HisSysDept> selectDeptList(HisSysDept dept);

    /**
     * 新增科室
     * @param dept
     * @return
     */
    int insertDept(HisSysDept dept);

    /**
     * 主键查询科室
     * @param deptId
     * @return
     */
    HisSysDept selectDeptByDeptId(Long deptId);

    /**
     * 更新科室
     * @param dept
     * @return
     */
    int updateDept(HisSysDept dept);

    /**
     * 根据科室名称查询科室数据
     * @param deptName
     * @return
     */
    HisSysDept selectDeptByDeptName(String deptName);

    /**
     * 批量删除科室
     * @param deptIds
     * @return
     */
    int deleteDeptByIds(@Param("deptIds") Long[] deptIds);
}
