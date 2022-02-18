package com.ruoyi.project.hissys.service;

import com.ruoyi.project.hissys.domain.HisSysDept;

import java.util.List;

public interface IHisSysDeptService {
    List<HisSysDept> selectDeptList(HisSysDept dept);

    int insertDept(HisSysDept dept);

    HisSysDept selectDeptById(Long deptId);

    int updateDept(HisSysDept dept);

    String checkDeptNameUnique(HisSysDept dept);

    int deleteDeptByIds(Long[] deptIds);
}
