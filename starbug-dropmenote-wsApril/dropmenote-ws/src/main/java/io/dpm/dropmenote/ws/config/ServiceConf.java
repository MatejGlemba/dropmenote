package io.dpm.dropmenote.ws.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Nastvuje JNDI connection pre entity. Inicializuje DB vrstvu
 * 
 * @author Martin Jurek
 *
 */
@Configuration
@EnableAsync
@EnableWebMvc
@EnableScheduling
@ComponentScan({ "io.dpm.dropmenote.ws.services", "io.dpm.dropmenote.ws.controller", "io.dpm.dropmenote.ws.handler", "io.dpm.dropmenote.ws.utils", "io.dpm.dropmenote.ws.scheduler" })
@PropertySource("classpath:config.properties")
public abstract class ServiceConf {

    private static Logger LOG = LoggerFactory.getLogger(ServiceConf.class);

    private static final int MAX_UPLOAD_SIZE_IN_MB = 5 * 1024 * 1024; // 5 MB

    {
        LOG.info("ServiceConf initialisation");
    }

    // To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // File upload support
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setMaxUploadSize(MAX_UPLOAD_SIZE_IN_MB * 2);
        cmr.setMaxUploadSizePerFile(MAX_UPLOAD_SIZE_IN_MB); // bytes
        return cmr;

    }

}