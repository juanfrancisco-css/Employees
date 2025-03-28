/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.models;

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
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "titles")
@NamedQueries({
    @NamedQuery(name = "Titles.findAll", query = "SELECT t FROM Titles t"),
    @NamedQuery(name = "Titles.findByEmpNo", query = "SELECT t FROM Titles t WHERE t.titlesPK.empNo = :empNo"),
    @NamedQuery(name = "Titles.findByTitle", query = "SELECT t FROM Titles t WHERE t.titlesPK.title = :title"),
    @NamedQuery(name = "Titles.findByFromDate", query = "SELECT t FROM Titles t WHERE t.titlesPK.fromDate = :fromDate"),
    @NamedQuery(name = "Titles.findByToDate", query = "SELECT t FROM Titles t WHERE t.toDate = :toDate")})
public class Titles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TitlesPK titlesPK;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;

    public Titles() {
    }

    public Titles(TitlesPK titlesPK) {
        this.titlesPK = titlesPK;
    }

    public Titles(int empNo, String title, Date fromDate) {
        this.titlesPK = new TitlesPK(empNo, title, fromDate);
    }

    public TitlesPK getTitlesPK() {
        return titlesPK;
    }

    public void setTitlesPK(TitlesPK titlesPK) {
        this.titlesPK = titlesPK;
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
        hash += (titlesPK != null ? titlesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titles)) {
            return false;
        }
        Titles other = (Titles) object;
        if ((this.titlesPK == null && other.titlesPK != null) || (this.titlesPK != null && !this.titlesPK.equals(other.titlesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.models.Titles[ titlesPK=" + titlesPK + " ]";
    }
    
}
