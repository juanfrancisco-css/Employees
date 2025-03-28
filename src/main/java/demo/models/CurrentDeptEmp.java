/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "current_dept_emp")
@NamedQueries({
    @NamedQuery(name = "CurrentDeptEmp.findAll", query = "SELECT c FROM CurrentDeptEmp c"),
    @NamedQuery(name = "CurrentDeptEmp.findByEmpNo", query = "SELECT c FROM CurrentDeptEmp c WHERE c.empNo = :empNo"),
    @NamedQuery(name = "CurrentDeptEmp.findByDeptNo", query = "SELECT c FROM CurrentDeptEmp c WHERE c.deptNo = :deptNo"),
    @NamedQuery(name = "CurrentDeptEmp.findByFromDate", query = "SELECT c FROM CurrentDeptEmp c WHERE c.fromDate = :fromDate"),
    @NamedQuery(name = "CurrentDeptEmp.findByToDate", query = "SELECT c FROM CurrentDeptEmp c WHERE c.toDate = :toDate")})
public class CurrentDeptEmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_no")
    private int empNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "dept_no")
    private String deptNo;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    public CurrentDeptEmp() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
}
