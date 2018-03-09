package com.self.learning.mapper.customer;

import com.self.learning.entity.customer.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee selectEmployee(Integer id);

    List<Employee> selectAllEmployees();

    Employee selectEmployeeByParam(@Param("id") int id, @Param("lastName") String lastName);

    Employee selectEmployeeByResultMap(Integer id);

    Employee selectEmployeeByMap(Map<String, Object> map);

    int insertEmployee(Employee employee);

    List<Employee> selectEmployeesByLastNameLike(@Param("lastName") String lastName);

    @MapKey("id")
    Map<Integer,Employee> selectEmployeesByLastNameLikeReturnMap(@Param("lastName") String lastName);

    List<Employee> selectEmployeeAndDepartmentById(Integer id);

    Employee selectEmployeeByAssociationStep(Integer id);

    Employee selectEmployeeByDeptId(Integer id);

    Employee selectEmployeeByDynamicSqlByIf(@Param("id") Integer id, @Param("lastName") String lastName, @Param
            ("email") String email);

    Employee selectEmployeeByDynamicSqlByChoose(@Param("id") Integer id, @Param("lastName") String lastName, @Param
            ("email") String email);

    void updateEmployeeByDynamicSql(Employee employee);

    void insertEmpsBatch(@Param("emps") List<Employee> emps);

    void deleteEmployeeById(Integer id);

    List<Employee> testInnerParameter(Employee employee);
}
