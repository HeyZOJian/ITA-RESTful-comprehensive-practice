package com.oocl.restfulcomprehensivepractice;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTests {
    @Autowired
    private ICompanyService companyService;

    @Test
    public void should_add_successfully_when_add_company(){
        assertThat(companyService.addCompany(new Company()),is(true));
    }

    @Test
    public void should_return_all_companies() {
        companyService.addCompany(new Company("a",0,null));
        companyService.addCompany(new Company("b",0,null));
        List<Company> companies = companyService.getAllCompanies();
        assertThat(companies.get(0).getCompanyName(),is("a"));
        assertThat(companies.get(1).getCompanyName(),is("b"));
    }

}
