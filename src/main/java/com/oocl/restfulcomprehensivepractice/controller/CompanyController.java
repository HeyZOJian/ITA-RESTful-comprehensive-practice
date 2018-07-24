package com.oocl.restfulcomprehensivepractice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
