package com.oocl.restfulcomprehensivepractice.service;

import com.oocl.restfulcomprehensivepractice.dao.ICompanyDao;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Company getCompanyById(int id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    @Override
    public boolean updateCompany(int id, Company company) {
        return false;
    }

    @Override
    public Company deleteCompany(int id) {
        return null;
    }
}
