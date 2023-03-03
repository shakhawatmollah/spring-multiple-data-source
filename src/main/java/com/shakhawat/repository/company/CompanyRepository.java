package com.shakhawat.repository.company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shakhawat.model.company.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
