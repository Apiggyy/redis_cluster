package com.self.learning.mapper.customer;

import com.self.learning.entity.customer.Department;

public interface DepartmentMapper {

    Department getDepartmentById(Integer id);

    Department getDepartmentByIdPlus(Integer id);

    Department getDepartmentByIdStep(Integer id);

}
