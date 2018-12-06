package com.cod.crud.service;

import com.cod.crud.bean.Employee;
import com.cod.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

//    查询所有员工
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

//    员工保存
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
}
