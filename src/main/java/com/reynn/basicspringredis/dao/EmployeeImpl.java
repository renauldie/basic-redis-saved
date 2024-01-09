package com.reynn.basicspringredis.dao;

import com.reynn.basicspringredis.model.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Renauldi Albarqawy
 * @Date 09/01/2024
 */
@Repository
public class EmployeeImpl implements EmployeeInterface {

    private final String hashReference= "Employee";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Employee> hashOperations;

    @Override
    public void saveEmployee(Employee employee) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, employee.getEmpId(), employee);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        hashOperations.put(hashReference, emp.getEmpId(), emp);
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteEmployee(Integer id) {
        hashOperations.delete(hashReference, id);
    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        hashOperations.putAll(hashReference, map);
    }
}
