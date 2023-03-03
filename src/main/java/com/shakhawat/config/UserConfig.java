package com.shakhawat.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.shakhawat.repository.user",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager"
)
public class UserConfig {

    @Autowired
    private DataSourceProperties dsProperties;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean userEntityManager()
            throws NamingException {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan("com.shakhawat.model.user");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(userHibernateProperties());

        return em;
    }

    @Bean
    @Primary
    public DataSource userDataSource() throws IllegalArgumentException, NamingException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dsProperties.getUser().driverClassName());
        dataSource.setUrl(dsProperties.getUser().url());
        dataSource.setUsername(dsProperties.getUser().username());
        dataSource.setPassword(dsProperties.getUser().password());

        return dataSource;
    }

    private Properties userHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",dsProperties.getUser().dialect());
        properties.put("hibernate.hbm2ddl.auto",dsProperties.getUser().ddlAuto());

        return properties;
    }

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager() throws NamingException {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userEntityManager().getObject());
        return transactionManager;
    }
}
