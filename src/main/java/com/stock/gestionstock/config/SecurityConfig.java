package com.stock.gestionstock.config;
import com.stock.gestionstock.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;
    //@Autowired
    //private Filter filter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //on va utiliser la objet userDetails pour que stpring recuperer/authentifier cette user
        auth.userDetailsService(applicationUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/**/authenticate").permitAll()
                //il faut que le demandeur soit authentifié
                .anyRequest().authenticated()
                //Api restful:on ne garde pas le status de user au niveau de notre api
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //il faut executer le filter avant d'executer toute les auttres requettes
      //  http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return  authenticationManagerBean();
    }

    //pour l'encryptage de password
    @Bean
    public PasswordEncoder passwordEncoder() throws Exception{
        return  new BCryptPasswordEncoder();
    }

}
