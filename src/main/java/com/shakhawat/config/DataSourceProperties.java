package com.shakhawat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.shakhawat.record.BrandRecord;
import com.shakhawat.record.CompanyRecord;
import com.shakhawat.record.UserRecord;

@Component
@ConfigurationProperties("datasource")
public class DataSourceProperties {
	
   private UserRecord user;
   private CompanyRecord company;
   private BrandRecord brand;

    public UserRecord getUser() {
        return user;
    }

    public void setUser(UserRecord user) {
        this.user = user;
    }

    public CompanyRecord getCompany() {
        return company;
    }

    public void setCompany(CompanyRecord company) {
        this.company = company;
    }

    public BrandRecord getBrand() {
        return brand;
    }

    public void setBrand(BrandRecord brand) {
        this.brand = brand;
    }
}
