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
@Table(name = "salaries")
@NamedQueries({
    @NamedQuery(name = "Salaries.findAll", query = "SELECT s FROM Salaries s"),
    @NamedQuery(name = "Salaries.findByEmpNo", query = "SELECT s FROM Salaries s WHERE s.salariesPK.empNo = :empNo"),
    @NamedQuery(name = "Salaries.findBySalary", query = "SELECT s FROM Salaries s WHERE s.salary = :salary"),
    @NamedQuery(name = "Salaries.findByFromDate", query = "SELECT s FROM Salaries s WHERE s.salariesPK.fromDate = :fromDate"),
    @NamedQuery(name = "Salaries.findByToDate", query = "SELECT s FROM Salaries s WHERE s.toDate = :toDate")})
public class Salaries implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalariesPK salariesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;

    public Salaries() {
    }

    public Salaries(SalariesPK salariesPK) {
        this.salariesPK = salariesPK;
    }

    public Salaries(SalariesPK salariesPK, int salary, Date toDate) {
        this.salariesPK = salariesPK;
        this.salary = salary;
        this.toDate = toDate;
    }

    public Salaries(int empNo, Date fromDate) {
        this.salariesPK = new SalariesPK(empNo, fromDate);
    }

    public SalariesPK getSalariesPK() {
        return salariesPK;
    }

    public void setSalariesPK(SalariesPK salariesPK) {
        this.salariesPK = salariesPK;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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
        hash += (salariesPK != null ? salariesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salaries)) {
            return false;
        }
        Salaries other = (Salaries) object;
        if ((this.salariesPK == null && other.salariesPK != null) || (this.salariesPK != null && !this.salariesPK.equals(other.salariesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.models.Salaries[ salariesPK=" + salariesPK + " ]";
    }
    
}
