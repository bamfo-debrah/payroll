/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexia.payroll;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author debrah
 */
@Entity
@Table(name = "emp")
@NamedQueries({@NamedQuery(name = "Employee.getAll", query = "SELECT e FROM Employee e ORDER BY e.lastName"),
@NamedQuery(name = "Employee.getById", query = "SELECT e FROM Employee e WHERE e.id=:id")})
public class Employee extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    
    private String ssfNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String residenceAdd;
    private String postalAdd;
    private String email;
    private String dateOfBirth;
    private String phoneNumber;
    private String nextOfKin;
    private BigDecimal basicSalary;
    @ManyToOne
    private Department department;

    public String getSsfNumber() {
        return ssfNumber;
    }

    public void setSsfNumber(String ssfNumber) {
        this.ssfNumber = ssfNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResidenceAdd() {
        return residenceAdd;
    }

    public void setResidenceAdd(String residenceAdd) {
        this.residenceAdd = residenceAdd;
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public int hashCode() {
       return this.ssfNumber.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Employee)) {
//            return false;
//        }
//        Employee other = (Employee) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
    
    if(!(object instanceof Employee)){
        return false;
    }
    
    Employee other=(Employee) object;
    
    if(this.ssfNumber.equals(other.ssfNumber))
    {
        return true;
    }
    return  false;
    }

    @Override
    public String toString() {
        return "com.nexia.payroll.Employee[ id=" + id + " ]";
    }
    
}
