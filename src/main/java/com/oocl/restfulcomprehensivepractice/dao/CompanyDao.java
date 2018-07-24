package com.oocl.restfulcomprehensivepractice.dao;

import com.oocl.restfulcomprehensivepractice.DB;
import com.oocl.restfulcomprehensivepractice.domain.Company;

import java.util.List;

public class CompanyDao implements ICompanyDao {
    @Override
    public List<Company> getAllCompanies() {
        return DB.getAllCompanies();
    }

    @Override
    public Company getCompanyById(int id) {
        return DB.getCompanyById(id);
    }

    @Override
    public boolean addCompany(Company company) {
        return DB.addCompany(company);
    }

    @Override
    public boolean updateCompany(int id, Company company) {
       return DB.updateCompany(id,company);
    }

    @Override
    public Company deleteCompany(int id) {
        return DB.deleteCompany(id);
    }
}
