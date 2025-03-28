/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "departments")
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d"),
    @NamedQuery(name = "Departments.findByDeptNo", query = "SELECT d FROM Departments d WHERE d.deptNo = :deptNo"),
    @NamedQuery(name = "Departments.findByDeptName", query = "SELECT d FROM Departments d WHERE d.deptName = :deptName")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "dept_no")
    private String deptNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "dept_name")
    private String deptName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departments")
    private List<DeptEmp> deptEmpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departments")
    private List<DeptManager> deptManagerList;

    public Departments() {
    }

    public Departments(String deptNo) {
        this.deptNo = deptNo;
    }

    public Departments(String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<DeptEmp> getDeptEmpList() {
        return deptEmpList;
    }

    public void setDeptEmpList(List<DeptEmp> deptEmpList) {
        this.deptEmpList = deptEmpList;
    }

    public List<DeptManager> getDeptManagerList() {
        return deptManagerList;
    }

    public void setDeptManagerList(List<DeptManager> deptManagerList) {
        this.deptManagerList = deptManagerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptNo != null ? deptNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.deptNo == null && other.deptNo != null) || (this.deptNo != null && !this.deptNo.equals(other.deptNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.models.Departments[ deptNo=" + deptNo + " ]";
    }
    
}
