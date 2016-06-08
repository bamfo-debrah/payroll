/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexia.payroll;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
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
public class EmployeeEarnings extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    private double percentage;
    private BigDecimal amount;
    @OneToOne
    private EarningTypes earning;

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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEarnings)) {
            return false;
        }
        EmployeeEarnings other = (EmployeeEarnings) object;
        return this.earning.equals(other.earning);
    }

    @Override
    public String toString() {
        if(this.percentage==0)
        {
            return this.earning.getName()+" "+this.amount;
        }
        
            return this.earning.getName()+" "+this.percentage;
        
    }
    
}
