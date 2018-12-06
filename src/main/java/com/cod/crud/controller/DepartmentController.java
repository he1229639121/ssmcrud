package com.cod.crud.controller;

import com.cod.crud.bean.Department;
import com.cod.crud.bean.Msg;
import com.cod.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//处理和部门有关的请求
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list =  departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
