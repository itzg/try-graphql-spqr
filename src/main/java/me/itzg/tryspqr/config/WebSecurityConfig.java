package me.itzg.tryspqr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Geoff Bourne
 * @since Dec 2018
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/error").permitAll()
        .anyRequest().fullyAuthenticated();
  }
}
