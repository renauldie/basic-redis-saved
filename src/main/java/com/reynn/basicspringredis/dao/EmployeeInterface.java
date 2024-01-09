package com.reynn.basicspringredis.dao;

import com.reynn.basicspringredis.model.Employee;

import java.util.Map;

/**
 * @author Renauldi Albarqawy
 * @Date 09/01/2024
 */

public interface EmployeeInterface {
    void saveEmployee(Employee employee);
    Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp);
    Map<Integer, Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    void saveAllEmployees(Map<Integer, Employee> map);
}
