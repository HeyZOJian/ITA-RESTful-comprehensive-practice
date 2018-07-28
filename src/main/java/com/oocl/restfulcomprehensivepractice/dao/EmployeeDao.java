package com.oocl.restfulcomprehensivepractice.dao;

import com.oocl.restfulcomprehensivepractice.DB;
import com.oocl.restfulcomprehensivepractice.domain.Employee;

import java.util.List;

/**
 * Created by Vito Zhuang on 7/28/2018.
 */
public class EmployeeDao implements IEmployeeDao {
	public List<Employee> findAll(){
		return DB.getAllEmployees();
	}

	public Employee findById(int id){
		return DB.getEmployeeById(id);
	}

	public List<Employee> findByGender(String gender){
		return DB.getEmployeesByGender(gender);
	}

	public boolean addEmployee(Employee employee){
		return DB.addEmployee(employee);
	}

	public boolean updateEmployee(int id, Employee employee){
		return DB.updateEmployee(id, employee);
	}

	public Employee deleteEmployee(int id){
		return DB.deleteEmployee(id);
	}

	public List<Employee> findAllEmployeeByPaging(int page, int size){
		return DB.getEmployeesByPaging(page, size);
	}
}
