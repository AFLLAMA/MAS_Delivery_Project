package mas.delivery.services;

import mas.delivery.CatalogueOfCompanies;
import mas.delivery.repo.CatalogueOfCompaniesRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogueServiceImpl {
    private CatalogueOfCompaniesRepo catalogueRepo;

    public CatalogueServiceImpl(CatalogueOfCompaniesRepo catalogue) {
        this.catalogueRepo = catalogue;
    }

    public List<CatalogueOfCompanies> getCatalogues(){
        List<CatalogueOfCompanies> catalogues = new ArrayList<>();
        catalogueRepo.findAll().iterator().forEachRemaining(e -> catalogues.add((CatalogueOfCompanies) e));
        return catalogues;
    }
}
