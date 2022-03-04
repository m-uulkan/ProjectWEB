package peaksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyServiceImple;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyServiceImple companyServiceImple;

    @Autowired
    public CompanyController(CompanyServiceImple companyServiceImple) {
        this.companyServiceImple = companyServiceImple;
    }

    @GetMapping("/new")
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/newCompany";

    }

    @PostMapping("/create")
    public String createCompany(@ModelAttribute("company") Company company) {
        companyServiceImple.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping
    public String getAllCompany(Model model) {
        model.addAttribute("companyList", companyServiceImple.companyList());
        return "company/getCompanies";
    }

    @GetMapping("/{id}")
    public String getCompanyBy(@PathVariable("id") Long id, Model model) {
        model.addAttribute("company", companyServiceImple.getCompanyById(id));
        return "company/getCompanyVsId";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("company", companyServiceImple.getCompanyById(id));
        return "company/editCompany";
    }

    @PatchMapping("/{id}")
    public String updateCompanies(@ModelAttribute("company") Company company, @PathVariable("id") Long id) {
        companyServiceImple.updateCompany(id, company);
        return "redirect:/companies";
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable("id") Long id, Model model) {
        companyServiceImple.removeCompanyById(id);
        return "redirect:/companies";
    }

}
