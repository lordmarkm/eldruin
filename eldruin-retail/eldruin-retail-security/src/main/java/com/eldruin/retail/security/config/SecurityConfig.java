package com.eldruin.retail.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.baldy.commons.security.services.BaldyCommonsSecurityServicesMarker;
import com.baldy.commons.security.services.BaseBaldyUserDetailsService;
import com.eldruin.retail.security.EldruinRetailSecurityMarker;

/**
 * Do not autoformat this class.
 * @author mbmartinez
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {
    BaldyCommonsSecurityServicesMarker.class,
    EldruinRetailSecurityMarker.class
})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = {
    BaldyCommonsSecurityServicesMarker.class
})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BaseBaldyUserDetailsService userDetailsService;

    @Bean
    public LocalValidatorFactoryBean localValidatorFactorybean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder
            .ignoring()
                .antMatchers("/images/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                /*
                 * All powerful admin man can do anything.
                 */
                .antMatchers("/admin**").hasRole("ADMIN")

                /*
                 * Manager can put new products into the website and stuff.
                 */
                .antMatchers("/manage**").hasRole("MANAGE")

                /*
                 * Customers who register for and log onto the site.
                 * They have order histories and stuff.
                 */
                .antMatchers("/customer**").hasRole("CUSTOMER")

                /*
                 * Everything else is for customers browsing pleasure
                 */
                .antMatchers("/**").permitAll()
                .and()
            .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login?msg=signout_success")
                .permitAll()
                .and()
            .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/login/authenticate")
                .defaultSuccessUrl("/auth/redirect", true)
                .failureUrl("/auth/login?msg=bad_credentials")
                .permitAll();
//                .and()
//            .rememberMe()
//                .key(env.getProperty("remember.me.key"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder  builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}