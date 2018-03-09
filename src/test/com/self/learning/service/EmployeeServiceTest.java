package com.self.learning.service;

import com.self.learning.entity.customer.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void selectEmployee() throws Exception {
        Employee employee = employeeService.selectEmployee(38);
        System.out.println(employee);
    }

    @Test
    public void insertEmployee() throws Exception {
        Employee employee = new Employee("messi", "messi@qq.com", "1");
        employeeService.insertEmployee(employee);
    }

    @Test
    public void deleteEmployeeById() throws Exception {
        employeeService.deleteEmployeeById(89);
    }

    @Test
    public void insertEmployeeBySpringData() throws Exception {
        Employee employee = new Employee("f1", "f1@qq.com", "1");
        employeeService.insertEmployeeBySpringData(employee);
    }

}