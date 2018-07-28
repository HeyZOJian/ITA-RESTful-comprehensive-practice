package com.oocl.restfulcomprehensivepractice.controller;

import com.oocl.restfulcomprehensivepractice.domain.Employee;
import com.oocl.restfulcomprehensivepractice.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.PAData;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vito Zhuang on 7/28/2018.
 */
@RequestMapping("/employees")
@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping(path = "")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	@GetMapping(path ="/{keyWord}")
	public List<Employee> findById(@PathVariable String keyWord){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(keyWord);
		if( !isNum.matches() ) {
			return employeeService.findByGender(keyWord);
		}else{
			List<Employee> list = new LinkedList<>();
			Employee employee = employeeService.findById(Integer.parseInt(keyWord));
			if(employee!=null) {
				list.add(employee);
			}
			return list;
		}
	}

	@GetMapping(path = "/page/{page}/pageSize/{size}")
	public List<Employee> findAllByPaging(@PathVariable int page,@PathVariable int size){
		return employeeService.findAllEmployeeByPaging(page,size);
	}

	@PostMapping(path = "")
	public ResponseEntity addEmployee(@RequestBody Employee employee){
		if(employeeService.addEmployee(employee)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		if(employeeService.updateEmployee(id,employee)){
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id){
		if(employeeService.deleteEmployee(id)){
			return ResponseEntity.status(HttpStatus.OK).build();
		}else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
