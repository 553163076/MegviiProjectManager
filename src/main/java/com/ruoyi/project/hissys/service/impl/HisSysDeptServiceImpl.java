package com.ruoyi.project.hissys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hissys.mapper.HisSysDeptMapper;
import com.ruoyi.project.hissys.domain.HisSysDept;
import com.ruoyi.project.hissys.service.IHisSysDeptService;

/**
 * 科室Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@Service
public class HisSysDeptServiceImpl implements IHisSysDeptService 
{
    @Autowired
    private HisSysDeptMapper hisSysDeptMapper;

    /**
     * 查询科室
     * 
     * @param deptId 科室ID
     * @return 科室
     */
    @Override
    public HisSysDept selectHisSysDeptById(Long deptId)
    {
        return hisSysDeptMapper.selectHisSysDeptById(deptId);
    }

    /**
     * 查询科室列表
     * 
     * @param hisSysDept 科室
     * @return 科室
     */
    @Override
    public List<HisSysDept> selectHisSysDeptList(HisSysDept hisSysDept)
    {
        return hisSysDeptMapper.selectHisSysDeptList(hisSysDept);
    }

    /**
     * 新增科室
     * 
     * @param hisSysDept 科室
     * @return 结果
     */
    @Override
    public int insertHisSysDept(HisSysDept hisSysDept)
    {
        hisSysDept.setCreateTime(DateUtils.getNowDate());
        return hisSysDeptMapper.insertHisSysDept(hisSysDept);
    }

    /**
     * 修改科室
     * 
     * @param hisSysDept 科室
     * @return 结果
     */
    @Override
    public int updateHisSysDept(HisSysDept hisSysDept)
    {
        hisSysDept.setUpdateTime(DateUtils.getNowDate());
        return hisSysDeptMapper.updateHisSysDept(hisSysDept);
    }

    /**
     * 批量删除科室
     * 
     * @param deptIds 需要删除的科室ID
     * @return 结果
     */
    @Override
    public int deleteHisSysDeptByIds(Long[] deptIds)
    {
        return hisSysDeptMapper.deleteHisSysDeptByIds(deptIds);
    }

    /**
     * 删除科室信息
     * 
     * @param deptId 科室ID
     * @return 结果
     */
    @Override
    public int deleteHisSysDeptById(Long deptId)
    {
        return hisSysDeptMapper.deleteHisSysDeptById(deptId);
    }
}
