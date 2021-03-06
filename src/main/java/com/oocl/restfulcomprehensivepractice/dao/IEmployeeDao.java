package com.oocl.restfulcomprehensivepractice.dao;

import com.oocl.restfulcomprehensivepractice.DB;
import com.oocl.restfulcomprehensivepractice.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vito Zhuang on 7/28/2018.
 */
@Component
public interface IEmployeeDao {
	List<Employee> findAll();

	Employee findById(int id);

	List<Employee> findByGender(String gender);

	boolean addEmployee(Employee employee);

	boolean updateEmployee(int id,Employee employee);

	boolean deleteEmployee(int id);

	List<Employee> findAllEmployeeByPaging(int page,int size);
}
