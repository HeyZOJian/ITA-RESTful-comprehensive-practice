package com.oocl.restfulcomprehensivepractice.controller;

import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
