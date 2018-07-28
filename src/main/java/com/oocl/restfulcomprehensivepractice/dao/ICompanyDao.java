package com.oocl.restfulcomprehensivepractice.dao;

import com.oocl.restfulcomprehensivepractice.domain.Company;

import java.util.List;

public interface ICompanyDao {
    List<Company> getAllCompanies();
    List<Company> getCompaniesByPaging(int pageNum, int size);
    Company getCompanyById(int id);
    boolean addCompany(Company company);
    boolean updateCompany(int id,Company company);
    boolean deleteCompany(int id);
}
