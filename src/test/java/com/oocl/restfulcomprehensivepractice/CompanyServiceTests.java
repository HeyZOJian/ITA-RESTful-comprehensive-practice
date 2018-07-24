package com.oocl.restfulcomprehensivepractice;
import com.oocl.restfulcomprehensivepractice.domain.Company;
import com.oocl.restfulcomprehensivepractice.service.ICompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(companyService.getAllCompanies());
    }

}
