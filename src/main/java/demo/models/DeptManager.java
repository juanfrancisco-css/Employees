/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "dept_manager")
@NamedQueries({
    @NamedQuery(name = "DeptManager.findAll", query = "SELECT d FROM DeptManager d"),
    @NamedQuery(name = "DeptManager.findByEmpNo", query = "SELECT d FROM DeptManager d WHERE d.deptManagerPK.empNo = :empNo"),
    @NamedQuery(name = "DeptManager.findByDeptNo", query = "SELECT d FROM DeptManager d WHERE d.deptManagerPK.deptNo = :deptNo"),
    @NamedQuery(name = "DeptManager.findByFromDate", query = "SELECT d FROM DeptManager d WHERE d.fromDate = :fromDate"),
    @NamedQuery(name = "DeptManager.findByToDate", query = "SELECT d FROM DeptManager d WHERE d.toDate = :toDate")})
public class DeptManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeptManagerPK deptManagerPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departments departments;
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;

    public DeptManager() {
    }

    public DeptManager(DeptManagerPK deptManagerPK) {
        this.deptManagerPK = deptManagerPK;
    }

    public DeptManager(DeptManagerPK deptManagerPK, Date fromDate, Date toDate) {
        this.deptManagerPK = deptManagerPK;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DeptManager(int empNo, String deptNo) {
        this.deptManagerPK = new DeptManagerPK(empNo, deptNo);
    }

    public DeptManagerPK getDeptManagerPK() {
        return deptManagerPK;
    }

    public void setDeptManagerPK(DeptManagerPK deptManagerPK) {
        this.deptManagerPK = deptManagerPK;
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

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptManagerPK != null ? deptManagerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptManager)) {
            return false;
        }
        DeptManager other = (DeptManager) object;
        if ((this.deptManagerPK == null && other.deptManagerPK != null) || (this.deptManagerPK != null && !this.deptManagerPK.equals(other.deptManagerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.models.DeptManager[ deptManagerPK=" + deptManagerPK + " ]";
    }
    
}
