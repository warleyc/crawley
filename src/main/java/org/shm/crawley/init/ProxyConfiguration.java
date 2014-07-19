package org.shm.crawley.init;


import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;


@Configuration
@Profile("dev")
public class ProxyConfiguration {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(ProxyConfiguration.class);

    @Inject
    private Environment env;

    @PostConstruct
    public void init() throws IOException {
        log.info("Proxy configuration!");
//        System.setProperty("https.proxyHost", "202.27.42.27");
//        System.setProperty("https.proxyPort", "8080");

    }
}
