package ru.itpark.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // блок, отвечающий за урлы и их доступы
                .antMatchers("/students/**").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addStudent").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/teachers/**").hasAnyAuthority("ADMIN")
                .antMatchers("/addTeacher").hasAnyAuthority("ADMIN")
                .antMatchers("/groups/**").hasAnyAuthority("ADMIN")
                .antMatchers("/addGroup").hasAnyAuthority("ADMIN")
                .antMatchers("/disciplines/**").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addDiscipline").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/courses/**").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addCourse").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/lessons/**").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addLesson").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/lessonScore/**").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addLesson").hasAnyAuthority("ADMIN", "TEACHER")
                .antMatchers("/addStudentEror").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/profile/**").hasAnyAuthority("TEACHER", "ADMIN") // разрешили админу и пользователям
                .anyRequest().authenticated() // все остальные запросы требуют предварительной авторизации
                .and()
                .formLogin() // блок с формой входа
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(86400)
                .and()
                .csrf().disable();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository =
                new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}