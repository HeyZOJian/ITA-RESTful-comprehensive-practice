package com.oocl.restfulcomprehensivepractice.service;

import com.oocl.restfulcomprehensivepractice.domain.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(int id);
    boolean addCompany(Company company);
    boolean updateCompany(int id,Company company);
    Company deleteCompany(int id);
}
