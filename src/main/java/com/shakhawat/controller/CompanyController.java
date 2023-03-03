package com.shakhawat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakhawat.model.company.Company;
import com.shakhawat.service.DefaultService;

@RestController
@RequestMapping("/api/v2")
public class CompanyController {

	private final DefaultService<Company,Long> defaultService;

    public CompanyController(DefaultService<Company, Long> defaultService) {
        this.defaultService = defaultService;
    }

    @PostMapping("/company")
    public Company createCompany(@RequestBody Company company) {
        return defaultService.save(company);
    }
    
}
