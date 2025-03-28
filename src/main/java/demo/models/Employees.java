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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmpNo", query = "SELECT e FROM Employees e WHERE e.empNo = :empNo"),
    @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByGender", query = "SELECT e FROM Employees e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_no")
    private Integer empNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private Character gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<Salaries> salariesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<DeptEmp> deptEmpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<DeptManager> deptManagerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<Titles> titlesList;

    public Employees() {
    }

    public Employees(Integer empNo) {
        this.empNo = empNo;
    }

    public Employees(Integer empNo, Date birthDate, String firstName, String lastName, Character gender, Date hireDate) {
        this.empNo = empNo;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public List<Salaries> getSalariesList() {
        return salariesList;
    }

    public void setSalariesList(List<Salaries> salariesList) {
        this.salariesList = salariesList;
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

    public List<Titles> getTitlesList() {
        return titlesList;
    }

    public void setTitlesList(List<Titles> titlesList) {
        this.titlesList = titlesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNo != null ? empNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.empNo == null && other.empNo != null) || (this.empNo != null && !this.empNo.equals(other.empNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.models.Employees[ empNo=" + empNo + " ]";
    }
    
}
