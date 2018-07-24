package com.oocl.restfulcomprehensivepractice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    ICompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping("/companies")
    public JSONObject addCompany(@RequestBody Company company){
        JSONObject res = new JSONObject();
        if(companyService.addCompany(company)){
            res.put("message","add company successfully");
        }
        else{
            res.put("message","add company failed");
        }
        return res;
    }

    @PutMapping("/companies/{companyId}")
    public JSONObject updateCompany(@RequestBody Company company
            ,@PathVariable int companyId){
        JSONObject res = new JSONObject();
        if(companyService.updateCompany(companyId,company)){
            res.put("message","update company successfully");
        }
        else{
            res.put("message","update company failed");
        }
        return res;
    }

    @DeleteMapping("/companies/{companyId}")
    public JSONObject deleteCompany(@PathVariable int companyId){
        JSONObject res = new JSONObject();
        Company company = companyService.deleteCompany(companyId);
        if(company!=null){
            res.put("company",company);
            res.put("message","delete company successfully");
        }
        else{
            res.put("message","delete company failed");
        }
        return res;
    }
}
