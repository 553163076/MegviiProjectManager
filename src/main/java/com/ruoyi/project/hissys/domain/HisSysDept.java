package com.ruoyi.project.hissys.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * @author 老金
 * @since 1.0
 * @date 2021-04-27
 * 尚医疗 - 系统管理 - 科室实体类型
 */
public class HisSysDept extends BaseEntity {
    // 定义属性
    @Excel(name = "科室序号", cellType = Excel.ColumnType.NUMERIC)
    private Long deptId;
    @NotBlank(message = "科室名称必须填写")
    @Excel(name = "科室名称")
    private String deptName;
    @Excel(name = "科室编号")
    private String deptCode;
    @Excel(name = "挂号量", cellType = Excel.ColumnType.NUMERIC)
    private long no;
    @Excel(name = "负责人")
    private String deptCharge;
    @Excel(name = "联系电话")
    private String phone;
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
    @Excel(name = "排序编号", cellType = Excel.ColumnType.NUMERIC)
    private int orderNum;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "HisSysDept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", no=" + no +
                ", deptCharge='" + deptCharge + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HisSysDept that = (HisSysDept) o;
        return no == that.no &&
                orderNum == that.orderNum &&
                Objects.equals(deptId, that.deptId) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(deptCode, that.deptCode) &&
                Objects.equals(deptCharge, that.deptCharge) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, deptCode, no, deptCharge, phone, status, orderNum);
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getDeptCharge() {
        return deptCharge;
    }

    public void setDeptCharge(String deptCharge) {
        this.deptCharge = deptCharge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
