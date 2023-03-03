package com.shakhawat.repository.brand;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shakhawat.model.brand.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long>{

}
