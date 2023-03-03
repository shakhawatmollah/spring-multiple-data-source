package com.shakhawat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakhawat.model.brand.Brand;
import com.shakhawat.service.DefaultService;

@RestController
@RequestMapping("/api/v3")
public class BrandController {

    private final DefaultService<Brand, Long> defaultService;

    public BrandController(DefaultService<Brand, Long> defaultService) {
        this.defaultService = defaultService;
    }

    @PostMapping("/brand")
    public Brand createBrand(@RequestBody Brand brand) {
        return defaultService.save(brand);
    }

}