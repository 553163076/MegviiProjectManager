package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.HisDept;
import com.ruoyi.project.system.mapper.HisDeptMapper;
import com.ruoyi.project.system.service.IHisDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 科室Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-18
 */
@Service
public class HisDeptServiceImpl implements IHisDeptService 
{
    @Autowired
    private HisDeptMapper hisDeptMapper;

    /**
     * 查询科室
     * 
     * @param deptId 科室ID
     * @return 科室
     */
    @Override
    public HisDept selectHisDeptById(Long deptId)
    {
        return hisDeptMapper.selectHisDeptById(deptId);
    }

    /**
     * 查询科室列表
     * 
     * @param hisDept 科室
     * @return 科室
     */
    @Override
    public List<HisDept> selectHisDeptList(HisDept hisDept)
    {
        return hisDeptMapper.selectHisDeptList(hisDept);
    }

    /**
     * 新增科室
     * 
     * @param hisDept 科室
     * @return 结果
     */
    @Override
    public int insertHisDept(HisDept hisDept)
    {
        hisDept.setCreateTime(DateUtils.getNowDate());
        return hisDeptMapper.insertHisDept(hisDept);
    }

    /**
     * 修改科室
     * 
     * @param hisDept 科室
     * @return 结果
     */
    @Override
    public int updateHisDept(HisDept hisDept)
    {
        hisDept.setUpdateTime(DateUtils.getNowDate());
        return hisDeptMapper.updateHisDept(hisDept);
    }

    /**
     * 批量删除科室
     * 
     * @param deptIds 需要删除的科室ID
     * @return 结果
     */
    @Override
    public int deleteHisDeptByIds(Long[] deptIds)
    {
        return hisDeptMapper.deleteHisDeptByIds(deptIds);
    }

    /**
     * 删除科室信息
     * 
     * @param deptId 科室ID
     * @return 结果
     */
    @Override
    public int deleteHisDeptById(Long deptId)
    {
        return hisDeptMapper.deleteHisDeptById(deptId);
    }
}
