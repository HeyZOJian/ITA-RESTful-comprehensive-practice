package com.oocl.restfulcomprehensivepractice;

import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.domain.Employee;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DB {
    private static int companyIdBuilder = 1;
    private static int employeeIdBuilder = 1;
    private static Map<Integer,Company> companyMap = new LinkedHashMap<>();
    private static Map<Integer,Employee> employeeMap = new LinkedHashMap<>();

    public static List<Company> getAllCompanies(){
        return new LinkedList<>(companyMap.values());
    }

    public static Company getCompanyById(int id){
        return companyMap.get(id);
    }

    public static boolean addCompany(Company company){
        try {
            companyMap.put(companyIdBuilder++, company);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean updateCompany(int id, Company company){
        try {
            if(companyMap.get(id)!=null) {
                companyMap.put(id, company);
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static Company deleteCompany(int id){
        return companyMap.remove(id);
    }

    public static List<Employee> getAllEmployees(){
        return new LinkedList<>(employeeMap.values());
    }

    public static Employee getEmployeeById(int id){
        return employeeMap.get(id);
    }

    public static boolean addEmployee(Employee employee){
        try{
            employeeMap.put(employeeIdBuilder++,employee);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static Employee updateEmployee(int id, Employee employee){
        employeeMap.put(id, employee);
        return employeeMap.get(id);
    }

    public static Employee deleteEmployee(int id){
        return employeeMap.remove(id);
    }

}
