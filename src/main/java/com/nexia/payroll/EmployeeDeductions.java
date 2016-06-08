/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexia.payroll;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author debrah
 */
@Entity
public class EmployeeDeductions extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    
    private double repaymentPeriod;
    private BigDecimal amount;
    @OneToOne
    private DeductionTypes deduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public double getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(double repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DeductionTypes getDeduction() {
        return deduction;
    }

    public void setDeduction(DeductionTypes deduction) {
        this.deduction = deduction;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDeductions)) {
            return false;
        }
        EmployeeDeductions other = (EmployeeDeductions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         if(this.repaymentPeriod==0)
        {
            return this.deduction.getName()+" "+this.amount;
        }
        
            return this.deduction.getName()+" "+this.repaymentPeriod;
    }
    
}
