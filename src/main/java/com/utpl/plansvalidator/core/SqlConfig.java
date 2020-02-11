package com.utpl.plansvalidator.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(
        basePackages = "com.utpl.plansvalidator.sql",
        entityManagerFactoryRef = "datasourceEntityManager",
        transactionManagerRef = "datasourceTransactionManager")
public class SqlConfig {
    @Autowired
    private Environment env;

    @Profile("dev")
    @Bean
    @ConfigurationProperties(prefix = "plansvalidator-dev.sql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Profile("prod")
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "plansvalidator-prod.sql.datasource")
    public DataSource prodDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean datasourceEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.utpl.plansvalidator.sql");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public PlatformTransactionManager datasourceTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(datasourceEntityManager().getObject());
        return transactionManager;
    }
}
