package org.shm.crawley.init;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;
import org.shm.crawley.helper.MapperHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Collections;

@Configuration
//@PropertySource({"classpath:/META-INF/crawley.properties"})
@ComponentScan(basePackages = {"org.shm.crawley.repository.gae", "org.shm.crawley.services", "org.shm.crawley.util", "org.shm.crawley.web.rest", "org.shm.crawley.helper"})
@Import(value = {
        DatabaseConfiguration.class})
public class ApplicationConfiguration {

    private final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Inject
    private Environment env;

    @PostConstruct
    public void init() throws IOException {
        log.info("ApplicationConfiguration for GAE started!");

        log.debug("Looking for Spring profiles...");
        if (env.getActiveProfiles().length == 0) {
            log.debug("No Spring profile configured, running with default configuration");
        } else {
            for (String profile : env.getActiveProfiles()) {
                log.debug("Detected Spring profile : {}", profile);
            }
        }

    }


    @Bean
    public MapperHelper mapperHelper() {
        log.info("bean MapperHelper() ");
        return new MapperHelper();
    }


    @Bean
    public Cache cache() {
        Cache cache = null;
        log.info("Bean Cache");
        try {
            cache = CacheManager.getInstance().getCacheFactory()
                    .createCache(Collections.emptyMap());
        } catch (CacheException e) {
            log.error("Cache cache():", e);
        }
        return cache;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("/META-INF/crawley.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

}
