package com.shakhawat.service;

import org.springframework.stereotype.Service;

import com.shakhawat.model.brand.Brand;
import com.shakhawat.repository.brand.BrandRepository;

@Service
public final class BrandServiceImpl implements DefaultService<Brand, Long> {
	
	private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

	@Override
	public Brand save(Brand obj) {
		return brandRepository.save(obj);
	}

	@Override
	public Iterable<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findById(Long id) {
		return brandRepository.findById(id).get();
	}

}
