package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 全てのリクエストに対して認証をかける
                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and().formLogin()
                    // ログインページを指定し、全ユーザにアクセスを許可する
                    .loginPage("/login").permitAll()
                    // Formの中のユーザ名とパスワードの値を指定する
                    .usernameParameter("username").passwordParameter("password")
                    // "/login"というパスに対してPOSTリクエストを投げる
                    .loginProcessingUrl("/login")
                    // ログイン成功時にアクセスするURLを指定する
                    .defaultSuccessUrl("/");
    }

}
