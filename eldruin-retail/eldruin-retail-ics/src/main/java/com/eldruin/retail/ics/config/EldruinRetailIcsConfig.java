package com.eldruin.retail.ics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eldruin.retail.ics.EldruinRetailIcsMarker;

@Configuration
@ComponentScan(basePackageClasses = EldruinRetailIcsMarker.class)
@EnableJpaRepositories(basePackageClasses = {
    EldruinRetailIcsMarker.class
}, repositoryImplementationPostfix = "CustomImpl")
public class EldruinRetailIcsConfig {

}
