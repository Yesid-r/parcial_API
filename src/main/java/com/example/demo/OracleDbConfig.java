package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", transactionManagerRef = "oracleTransactionManager", 
	basePackages = { "com.example.demo.repositories" })
public class OracleDbConfig {
	@Autowired
	private Environment environment;
	
	@Bean(name = "oracleDataSource")
	public DataSource oracleDatasource() {
		
		System.out.println(environment.getProperty("oracle.datasource.url"));
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("oracle.datasource.url"));
		driverManagerDataSource.setUsername(environment.getProperty("oracle.datasource.username"));
		driverManagerDataSource.setPassword(environment.getProperty("oracle.datasource.password"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("oracle.datasource.driver-class-name"));
		
		return driverManagerDataSource;
	}
	
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(oracleDatasource());
		entityManagerFactoryBean.setPackagesToScan("com.example.demo.entities");
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter =  new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		
		Map<String, Object> propiedades = new HashMap<>();
		propiedades.put("hibernate.hbm2ddl.auto", environment.getProperty("oracle.jpa.hibernate.ddl.auto"));
		propiedades.put("hibernate.show-sql", environment.getProperty("oracle.jpa.show-sql"));
		
		entityManagerFactoryBean.setJpaPropertyMap(propiedades);
		
		return entityManagerFactoryBean;
	}
	
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(oracleEntityManagerFactoryBean().getObject());
		
		return jpaTransactionManager;
	}

}
