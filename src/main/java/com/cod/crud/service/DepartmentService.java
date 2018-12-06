package com.cod.crud.service;

import com.cod.crud.bean.Department;
import com.cod.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        //查出所有部门信息
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
