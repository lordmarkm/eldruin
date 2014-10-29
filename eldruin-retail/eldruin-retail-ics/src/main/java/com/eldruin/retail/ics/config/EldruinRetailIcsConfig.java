package com.eldruin.retail.ics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eldruin.retail.ics.EldruinRetailIcsMarker;

@Configuration
@ComponentScan(basePackageClasses = EldruinRetailIcsMarker.class)
@EnableTransactionManagement
public class EldruinRetailIcsConfig {

}
