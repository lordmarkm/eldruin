package com.eldruin.retail.dashboard.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.baldy.commons.web.config.BaldyCommonsWebConfigMarker;
import com.eldruin.retail.core.config.EldruinRetailCoreConfigMarker;
import com.eldruin.retail.dashboard.EldruinRetailDashboardMarker;
import com.eldruin.retail.ics.EldruinRetailIcsMarker;
import com.eldruin.retail.security.EldruinRetailSecurityMarker;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * @author mbmartinez
 */
@Configuration
@ComponentScan(basePackageClasses = {
    BaldyCommonsWebConfigMarker.class,
    EldruinRetailCoreConfigMarker.class,
    EldruinRetailIcsMarker.class,
    EldruinRetailSecurityMarker.class,
    EldruinRetailDashboardMarker.class
})
public class EldruinDashboardConfig extends WebMvcConfigurationSupport {

    //Enable direct access to .html, .css, etc
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); 
    }

    //Override fail on unknown properties
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.addDefaultHttpMessageConverters(converters);
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) converter)
                    .getObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .registerModule(new JodaModule())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            }
        }
    }
}
