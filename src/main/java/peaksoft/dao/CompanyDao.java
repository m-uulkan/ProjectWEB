package peaksoft.dao;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyDao {

    void addCompany(Company company);
    void updateCompany(Long id,Company company);
    List<Company> companyList();
    Company getCompanyById(Long id);
    void removeCompanyById(Long id);


}
