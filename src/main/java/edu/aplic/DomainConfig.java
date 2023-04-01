package edu.aplic;


import edu.aplic.jpa.model.Material;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Clase para manejar la configuración del dominio del negocio (acceso a BD+JPA)
 * @author BAOZ
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("edu.aplic.jpa.repositories")
public class DomainConfig {
    
@Autowired 
private Environment env;

    @Bean
    public DataSource dataSource() {
    DriverManagerDataSource oDS = new DriverManagerDataSource();
        oDS.setUrl(env.getProperty("spring.datasource.url"));
        oDS.setUsername(env.getProperty("spring.datasource.username"));
        oDS.setPassword(env.getProperty("spring.datasource.password"));
        oDS.setDriverClassName(env.getProperty("spring.datasource.driver"));
        return oDS;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean emf = 
            new LocalContainerEntityManagerFactoryBean();        
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    Properties jpaProperties = new Properties();
    
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(Material.class.getPackage().getName());
        adapter.setDatabase(Database.POSTGRESQL);      
        emf.setJpaVendorAdapter(adapter);
        
        jpaProperties.put("spring.jpa.hibernate.naming.physical-strategy", 
            env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
        emf.setJpaProperties(jpaProperties);
        jpaProperties.put("spring.jpa.properties.hibernate.enable_lazy_load_no_trans", 
            env.getProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans"));
        emf.setJpaProperties(jpaProperties);
        
        return emf;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
    JpaTransactionManager oTxMng = new JpaTransactionManager();
        oTxMng.setEntityManagerFactory(entityManagerFactory().getObject());
        return oTxMng;
    }
}
