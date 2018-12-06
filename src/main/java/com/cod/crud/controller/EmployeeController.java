package com.cod.crud.controller;


import com.cod.crud.bean.Employee;
import com.cod.crud.bean.Msg;
import com.cod.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//处理员工crud请求
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public  Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }

    //导入jackson包
    @RequestMapping("/emps")

    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn",defaultValue = "1") Integer pn){
//        引入PageHelper分页插件
//        在查询之前只需要调用,插入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是分页查询
        List<Employee> emps = employeeService.getAll();
//      使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
//      封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
        PageInfo page = new PageInfo(emps,5);
        return Msg.success().add("pageInfo",page);
    }

//    查询员工数据（分页查询）
    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
//        引入PageHelper分页插件
//        在查询之前只需要调用,插入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是分页查询
        List<Employee> emps = employeeService.getAll();
//      使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
//      封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);

        return "list";
    }
}
