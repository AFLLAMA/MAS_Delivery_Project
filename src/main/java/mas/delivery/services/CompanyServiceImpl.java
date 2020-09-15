package mas.delivery.services;

import mas.delivery.CatalogueOfCompanies;
import mas.delivery.Company;
import mas.delivery.repo.CatalogueOfCompaniesRepo;
import mas.delivery.repo.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl {
    private CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo company) {
        this.companyRepo = company;
    }

    public List<Company> getCompanies(){
        List<Company> companies = new ArrayList<>();
        companyRepo.findAll().iterator().forEachRemaining(e -> companies.add((Company) e));
        return companies;
    }

    public Company getCompanyByID(long id){
        return (Company) companyRepo.findById(id).get();
    }
}
