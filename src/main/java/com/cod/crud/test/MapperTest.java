package com.cod.crud.test;

import com.cod.crud.bean.Department;
import com.cod.crud.bean.Employee;
import com.cod.crud.dao.DepartmentMapper;
import com.cod.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

//spring单元测试
//1导入springtest模块
//2@ContextConfiguration指定spring配置的位置
//3直接autowired要使用的组件
//测试dao层的工作
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
//    测试
    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        //1.插入几个部门

//        departmentMapper.insertSelective(
//                new Department(null,"开发部"));
//        departmentMapper.insertSelective(
//                new Department(null,"测试部"));

        //2.生成员工数据，测试员工插入
//          employeeMapper.insertSelective(
//                new Employee(null,"Jerry","M","Jerry@cod.com",1)
//          );
        //3.批量插入多个员工，使用可以执行批量操作的sqlsession
//        for (){
//            employeeMapper.insertSelective(
//               new Employee(null,"Jerry","M","Jerry@cod.com",1)
//          );
//        }
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@123.com",1));
        }
        System.out.println("批量执行完成");
    }
}
