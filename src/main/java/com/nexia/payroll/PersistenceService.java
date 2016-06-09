/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexia.payroll;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author debrah
 */
@Stateless
public class PersistenceService {

    @PersistenceContext
    EntityManager manager;

    //Reading from database
    public List<Employee> getEmployees() {
        return manager.createNamedQuery("Employee.getAll").getResultList();

    }

    public Employee getEmployeeById(Long id) {
        return (Employee) manager.createNamedQuery("Employee.getById").setParameter("id", id).getSingleResult();
    }

    public List<Department> getDepartments() {
        return manager.createNamedQuery("Department.getall").getResultList();
    }

    public Department getDepartmentById(Long id) {
        return (Department) manager.createNamedQuery("Department.getById").setParameter("id", id).getSingleResult();

    }

    public Department getDepartmentByName(String name) {
        return (Department) manager.createNamedQuery("Department.getByName").setParameter("name", name).getSingleResult();

    }

    public List<EarningTypes> getEarningTypes() {
        return manager.createNamedQuery("EarningType.getAll").getResultList();
    }

    public EarningTypes getEarningById(Long id) {
        return (EarningTypes) manager.createNamedQuery("EarningType.getById").setParameter("id", id).getSingleResult();

    }

    public List<EarningTypes> getEarningTypesByType(EarningTypes.EarningType type) {
        return manager.createNamedQuery("EarningType.getByType").setParameter("type", type).getResultList();

    }

    public List<EarningTypes> getEarningTypeByName(String name) {
        return manager.createNamedQuery("EarningType.getByName").setParameter("name", name).getResultList();

    }

    public List<DeductionTypes> getDeductionTypes() {
        return manager.createNamedQuery("DeductionTypes.getAll").getResultList();
    }

    public DeductionTypes getDeductionById(Long id) {
        return (DeductionTypes) manager.createNamedQuery("EarningType.getById").setParameter("id", id).getSingleResult();

    }

    public List<DeductionTypes> getDeductionByType(DeductionTypes.RepaymentType type) {
        return manager.createNamedQuery("DeductionTypes.getByType").setParameter("type", type).getResultList();

    }

    public List<DeductionTypes> getDeductionByName(String name) {
        return manager.createNamedQuery("DeductionTypes.getByName").setParameter("name", name).getResultList();

    }

    //saving data to the database
    public void saveEmployee(Employee emp) {
        if (emp.id == null) {
            manager.persist(emp);
        } else {
            manager.merge(emp);
        }
    }

    public void saveDepartment(Department dept) {
        if (dept.id == null) {
            manager.persist(dept);
        } else {
            manager.merge(dept);
        }
    }

    public void saveEarningType(EarningTypes earn) {

        if (earn.id == null) {
            manager.persist(earn);
        } else {
            manager.merge(earn);
        }
    }

    public void saveDeductionType(DeductionTypes deduct) {
        if (deduct.id == null) {
            manager.persist(deduct);
        } else {
            manager.merge(deduct);
        }
    }

    public void saveEmployeeEarnings(EmployeeEarnings earnings, long employeeId) {
        Employee employee = getEmployeeById(employeeId);
        boolean added = employee.getEmployeeEarnings().add(earnings);
        if (added) {
            manager.merge(employee);
        } else {
            //to do throw exception
        }

    }

    public void saveEmployeeDeductions(EmployeeDeductions deductions, long employeeId) {
        Employee employee = getEmployeeById(employeeId);
        boolean added = employee.getEmployeeDeductions().add(deductions);
        if (added) {
            manager.merge(employee);
        } else {
            //to do throw exception
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
