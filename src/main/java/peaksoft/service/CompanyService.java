package peaksoft.service;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);
    void updateCompany(Long id,Company company);
    List<Company> companyList();
    Company getCompanyById(Long id);
    void removeCompanyById(Long id);


}
