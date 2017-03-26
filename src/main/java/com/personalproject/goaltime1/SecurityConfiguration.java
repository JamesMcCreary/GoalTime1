package com.personalproject.goaltime1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.personalproject.goaltime1.security.AccountAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountAuthenticationProvider accountAuthenticationProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Autowired
    //    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    //    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
        jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username,password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

        ////.usersByUsernameQuery(usersQuery)
        // .usersByUsernameQuery("select username, password, active from users where username=?")
        ////.authoritiesByUsernameQuery(rolesQuery)
        //.authoritiesByUsernameQuery("select username, role from user_roles where username=?")
        //.dataSource(dataSource);
        //.passwordEncoder(bCryptPasswordEncoder);

        //        FROM http://www.java2blog.com/2016/09/spring-security-database-authentication-example.html
        //        users-by-username-query="select username, password, active from users where username=?"
        //                authorities-by-username-query="select username, role from user_roles where username=?" />
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/home").permitAll()
        .antMatchers("/signup").permitAll()
        .antMatchers("/signin").permitAll()
        .antMatchers("/addTask").hasRole("USER")
        .antMatchers("/taskList").access("hasRole('ROLE_USER')")
        .and().csrf().disable();


        //                .antMatchers("/login").permitAll()
        //                .antMatchers("/registration").permitAll()
        //                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
        //                .authenticated().and().csrf().disable().formLogin()
        //                .loginPage("/login").failureUrl("/login?error=true")
        //                .defaultSuccessUrl("/admin/home")
        //                .usernameParameter("email")
        //                .passwordParameter("password")
        //                .and().logout()
        //                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //                .logoutSuccessUrl("/").and().exceptionHandling()
        //                .accessDeniedPage("/access-denied");
    }
    //    @Bean
    //    public DaoAuthenticationProvider authenticationProvider() {
    //        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //        authenticationProvider.setUserDetailsService(accountDetailsService);
    //        authenticationProvider.setPasswordEncoder(passwordEncoder);
    //        return authenticationProvider;
    //    }
    //
    // @Override
    // protected void registerAuthentication(AuthenticationManagerBuilder auth)
    // throws Exception {
    // auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    // }
    // to the below
    //
    // @Override
    // protected void registerAuthentication(AuthenticationManagerBuilder auth)
    // throws Exception {
    // auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder).and
    // jdbcAuthentication().dataSource(dataSource);
    // }
    //

    //    @Configuration
    //    @Order(1)
    //    class BaseWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    //
    //        @Override
    //        protected void configure(HttpSecurity http) throws Exception {
    //
    //            // @formatter:off
    //
    //            http.authorizeRequests().antMatchers("/**").permitAll()
    //            // .antMatchers("/admin/**").hasRole("ADMIN")
    //            // .antMatchers("/welcome", "/signup", "/signin",
    //            // "/test").permitAll()
    //            // .anyRequest().hasRole("USER")
    //            // .anyRequest().authenticated()
    //            .and()
    //            // .formLogin()
    //            // .loginPage("/signin")
    //            // .permitAll()
    //            // .and()
    //            .httpBasic().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutsuccess").and()
    //            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //
    //            // @formatter:on
    //
    //        }
    //
    //    }

}
