package com.oocl.restfulcomprehensivepractice.service;

import com.oocl.restfulcomprehensivepractice.dao.IEmployeeDao;
import com.oocl.restfulcomprehensivepractice.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vito Zhuang on 7/28/2018.
 */
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findByGender(String gender) {
		return employeeDao.findByGender(gender);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(int id, Employee employee) {
		Employee employee1 = employeeDao.findById(id);
		employee1.setName(employee.getName()!=null?employee.getName():employee1.getName());
		employee1.setAge(employee.getAge()!=0?employee.getAge():employee1.getAge());
		employee1.setGender(employee.getGender()!=null?employee.getGender():employee1.getGender());
		employee1.setSalary(employee.getSalary()!=0?employee.getSalary():employee1.getSalary());
		return employeeDao.updateEmployee(id,employee1);
	}
	@Override
	public boolean deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployeeByPaging(int page, int size) {
		return employeeDao.findAllEmployeeByPaging(page,size);
	}
}
