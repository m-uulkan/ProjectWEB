package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CompanyDao;

import peaksoft.model.Company;

import java.util.List;
@Service
public class CompanyServiceImple implements CompanyService{

   private CompanyDao companyDao;

    @Autowired
 public CompanyServiceImple(CompanyDao companyDao) {
  this.companyDao = companyDao;
 }

   @Override
    public void addCompany(Company company) {
    companyDao.addCompany(company);

    }

    @Override
    public void updateCompany(Long id,Company company) {
     companyDao.updateCompany(id,company);


    }
    @Override
    public List<Company> companyList() {
        return companyDao.companyList();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void removeCompanyById(Long id) {
    companyDao.removeCompanyById(id);

    }
}
