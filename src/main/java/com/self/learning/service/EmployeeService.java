package com.self.learning.service;

import com.self.learning.dao.redis.EmployeeDaoRedisImpl;
import com.self.learning.entity.customer.Employee;
import com.self.learning.mapper.customer.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeemapper;

    @Autowired
    private EmployeeDaoRedisImpl employeeDao;

    @Cacheable(value="defaultCache",key="'employee_id_'+#id")
    public Employee selectEmployee(Integer id) {
        return employeemapper.selectEmployee(id);
    }

    @CachePut(value="defaultCache",key="'employee_id_'+#employee.id")
    public Employee insertEmployee(Employee employee) {
        employeemapper.insertEmployee(employee);
        return employee;
    }

    @CacheEvict(value="defaultCache",key="'employee_id_'+#id")
    public void deleteEmployeeById(Integer id) {
        employeemapper.deleteEmployeeById(id);
    }


    public boolean insertEmployeeBySpringData(Employee employee) {
        int result = employeemapper.insertEmployee(employee);
        if (result > 0) {
            return employeeDao.insert("employee_id_" + employee.getId(), employee);
        }
        return false;
    }

}
