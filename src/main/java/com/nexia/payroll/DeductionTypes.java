/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexia.payroll;

import com.sun.xml.internal.fastinfoset.util.FixedEntryStringIntMap;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author debrah
 */
@Entity
@NamedQueries({@NamedQuery(name = "DeductionTypes.getAll", query = "SELECT e FROM EarningTypes e ORDER BY e.name"),
@NamedQuery(name = "DeductionTypes.getById", query = "SELECT e from EarningTypes e WHERE e.id=:id"),
@NamedQuery(name = "DeductionTypes.getByName", query = "SELECT e from EarningTypes e WHERE e.name=:name"),
@NamedQuery(name = "DeductionTypes.getByType",query = "SELECT e from EarningTypes e WHERE e.type=:type")})
public class DeductionTypes extends AbstractEntity{
    private static final long serialVersionUID = 1L;
   @Column(name = "name")
    private String name;
   @Column(name = "type")
   private RepaymentType type;
   
   public enum RepaymentType{
       Fixed,installments }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public RepaymentType getType() {
        return type;
    }

    public void setType(RepaymentType type) {
        this.type = type;
    }
    
   

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
        if (!(object instanceof DeductionTypes)) {
            return false;
        }
        DeductionTypes other = (DeductionTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name+" "+this.type;
    }
    
}
