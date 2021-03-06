package com.oocl.restfulcomprehensivepractice;

import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.domain.Employee;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DB {
    private static int companyIdBuilder = 1;
    private static int employeeIdBuilder = 1;
    private static Map<Integer, Company> companyMap = new LinkedHashMap<>();
    private static Map<Integer, Employee> employeeMap = new LinkedHashMap<>();

    public static List<Company> getAllCompanies() {
        return new LinkedList<>(companyMap.values());
    }

    public static Company getCompanyById(int id) {
        return companyMap.get(id);
    }

    public static List<Company> getCompaniesByPaging(int pageNum, int size) {
        List<Company> companies = getAllCompanies();
        int fromIndex = (pageNum - 1) * size;
        int toIndex = (pageNum - 1) * size + size;
        toIndex = toIndex > companies.size()?companies.size():toIndex;
        return companies.subList(fromIndex, toIndex);
    }

    public static boolean addCompany(Company company) {
        try {
            companyMap.put(companyIdBuilder++, company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updateCompany(int id, Company company) {
        try {
            if (companyMap.get(id) != null) {
                companyMap.put(id, company);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteCompany(int id) {
	    Company company = companyMap.get(id);
	    if(company!=null){
    	    List<Employee> employees = company.getEmployees();
    	    for(Employee employee : employees){
    		    employeeMap.remove(employee.getId());
	        }
	        return true;
        }
        else{
	    	return false;
	    }
    }

    public static List<Employee> getAllEmployees() {
        return new LinkedList<>(employeeMap.values());
    }

    public static Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    public static boolean addEmployee(Employee employee) {
        try {
            employeeMap.put(employeeIdBuilder++, employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updateEmployee(int id, Employee employee) {
        if(employeeMap.get(id)!=null) {
	        employeeMap.put(id, employee);
	        return true;
        }else{
        	return false;
        }
    }

    public static boolean deleteEmployee(int id) {
        if(employeeMap.get(id)!=null) {
	        employeeMap.remove(id);
            return true;
        }
        else{
        	return false;
        }
    }

	public static List<Employee> getEmployeesByGender(String gender) {
		return employeeMap.values().stream()
				.filter(employee -> employee.getGender().equals(gender))
				.collect(Collectors.toList());
    }

	public static List<Employee> getEmployeesByPaging(int page, int size) {
		List<Employee> employees = getAllEmployees();
		int fromIndex = (page - 1) * size;
		int toIndex = (page - 1) * size + size;
		toIndex = toIndex > employees.size()?employees.size():toIndex;
		return employees.subList(fromIndex, toIndex);
    }
}
