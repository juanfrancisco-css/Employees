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
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "dept_emp_latest_date")
@NamedQueries({
    @NamedQuery(name = "DeptEmpLatestDate.findAll", query = "SELECT d FROM DeptEmpLatestDate d"),
    @NamedQuery(name = "DeptEmpLatestDate.findByEmpNo", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.empNo = :empNo"),
    @NamedQuery(name = "DeptEmpLatestDate.findByFromDate", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.fromDate = :fromDate"),
    @NamedQuery(name = "DeptEmpLatestDate.findByToDate", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.toDate = :toDate")})
public class DeptEmpLatestDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_no")
    private int empNo;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    public DeptEmpLatestDate() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
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
