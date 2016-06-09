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
@NamedQueries({
    @NamedQuery(name = "EarningType.getAll", query = "SELECT e from EarningTypes e ORDER BY e.name"),
    @NamedQuery(name = "EarningType.getByName", query = "SELECT e from EarningTypes e WHERE e.name=:name"),
    @NamedQuery(name = "EarningType.getByType", query = "SELECT e from EarningTypes e WHERE e.type=:type"),
    @NamedQuery(name = "EarningType.getById", query = "SELECT e from EarningTypes e WHERE e.id=:id")})
public class EarningTypes extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private EarningType type;

    public EarningType getType() {
        return type;
    }

    public void setType(EarningType type) {
        this.type = type;
    }

    public enum EarningType {

        Fixed, Percentage
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.type.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EarningTypes)) {
            return false;
        }
        EarningTypes other = (EarningTypes) object;
        if (!(this.name.equals(other.name) && this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name + "  " + this.type;
    }

}
