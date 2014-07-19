package org.shm.crawley.init;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

@Configuration
//@EnableJpaRepositories("org.shm.crawley.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

    private static final Logger log = Logger.getLogger(DatabaseConfiguration.class.getName());

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        log.info("bean entityManagerFactory() ");
        return Persistence.createEntityManagerFactory("org.shm.crawley");
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }

}
