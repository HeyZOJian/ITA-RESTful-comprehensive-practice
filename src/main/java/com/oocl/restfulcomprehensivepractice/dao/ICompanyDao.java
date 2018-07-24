package com.oocl.restfulcomprehensivepractice.dao;

import com.oocl.restfulcomprehensivepractice.domain.Company;

import java.util.List;

public interface ICompanyDao {
    List<Company> getAllCompanies();
    Company getCompanyById(int id);
    boolean addCompany(Company company);
    boolean updateCompany(int id,Company company);
    Company deleteCompany(int id);
}
