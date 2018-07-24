package com.oocl.restfulcomprehensivepractice;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTests {
    @Autowired
    private ICompanyService companyService;

    @Test
    public void should_add_successfully_when_add_company(){
        assertEquals(companyService.addCompany(new Company()),true);
    }

    @Test
    public void should_return_all_companies() {
        companyService.addCompany(new Company("a",0,null));
        companyService.addCompany(new Company("b",0,null));
        List<Company> companies = companyService.getAllCompanies();
        assertEquals(companies.get(0).getCompanyName(),"a");
        assertEquals(companies.get(1).getCompanyName(),"b");
    }

    @Test
    public void should_return_correct_company_when_given_a_exist_id(){
        companyService.addCompany(new Company("a",0,null));
        companyService.addCompany(new Company("b",0,null));
        Company company = companyService.getCompanyById(2);
        assertEquals(company.getCompanyName(),"b");
    }

    @Test
    public void should_return_null_when_given_a_not_exist_id(){
        Company company = companyService.getCompanyById(100);
        assertEquals(company,null);
    }

    @Test
    public void should_update_successfully_and_return_true_when_update_a_exist_company_info(){
        companyService.addCompany(new Company("a",0,null));
        assertEquals(companyService.updateCompany(
                1,
                new Company("b",
                        0,
                        null))
                ,true);
        assertEquals(companyService.getCompanyById(1).getCompanyName(),"b");
    }

    @Test
    public void should_update_failed_and_return_false_when_update_a_not_exist_company_info(){
        companyService.addCompany(new Company("a",0,null));
        companyService.updateCompany(1,new Company("b",0,null));
        assertEquals(companyService.updateCompany(
                100,
                new Company("b",
                        0,
                        null))
                ,false);
    }

    @Test
    public void should_delete_successfully_when_delete_a_exist_company(){
        companyService.addCompany(new Company("a",0,null));
        Company company = companyService.deleteCompany(1);
        assertEquals(company.getCompanyName(),"a");
        assertEquals(companyService.getAllCompanies().size(),0);
    }

    @Test
    public void should_delete_failed_when_delete_a_not_exist_company(){
        companyService.addCompany(new Company("a",0,null));
        Company company = companyService.deleteCompany(100);
        assertEquals(company,null);
        assertEquals(companyService.getAllCompanies().size(),1);
    }


}
