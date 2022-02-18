package com.ruoyi.project.hissys.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.project.hissys.domain.HisSysDept;
import com.ruoyi.project.hissys.mapper.HisSysDeptMapper;
import com.ruoyi.project.hissys.service.IHisSysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科室管理服务
 */
@Service
public class HisSysDeptServiceImpl implements IHisSysDeptService {
    @Autowired
    private HisSysDeptMapper deptMapper;

    /**
     * 删除科室
     * @param deptIds
     * @return
     */
    @Override
    public int deleteDeptByIds(Long[] deptIds) {
        // 考虑科室中是否有医生。员工。
        // 缺少用户管理功能，暂时直接删除。

        return deptMapper.deleteDeptByIds(deptIds);
    }

    /**
     * 查询科室名称是否在表格中存在。
     * @param dept
     * @return
     */
    @Override
    public String checkDeptNameUnique(HisSysDept dept) {
        HisSysDept info = deptMapper.selectDeptByDeptName(dept.getDeptName());
        if(info != null){
            // 有数据
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 更新科室
     * @param dept
     * @return
     */
    @Override
    public int updateDept(HisSysDept dept) {
        return deptMapper.updateDept(dept);
    }

    /**
     * 根据科室主键查询详情
     * @param deptId
     * @return
     */
    @Override
    public HisSysDept selectDeptById(Long deptId) {
        return deptMapper.selectDeptByDeptId(deptId);
    }

    /**
     * 新增科室
     * @param dept
     * @return
     */
    @Override
    public int insertDept(HisSysDept dept) {
        return deptMapper.insertDept(dept);
    }

    /**
     * 分页查询科室
     * @param dept
     * @return
     */
    @Override
    public List<HisSysDept> selectDeptList(HisSysDept dept) {
        return deptMapper.selectDeptList(dept);
    }
}
