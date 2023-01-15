package com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.security;

import com.yonggamsa.withsuyeonjung.user.framework.configuration.spring.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@EnableWebSecurity
@Configuration
@PropertySource(value = "classpath:application-oauth.yml", factory = YamlPropertySourceFactory.class)
public class WebSecurityConfig{

    private static List<String> clients = Arrays.asList("google");
    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";

    @Autowired
    private Environment env;
     @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        List<ClientRegistration> registrations = clients.stream()
                .map(client -> getRegistration(client))
                .filter(registration -> registration != null)
                .collect(Collectors.toList());
        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration getRegistration(String client){

        if(client == null) {
            return null;
        }

        String clientId = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-id");
        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");

        if(client.equals("google")) {
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(clientId).clientSecret(clientSecret).build();
        }

        return null;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/h2-console/**","favicon.ico").permitAll()
                .anyRequest().authenticated()
                    .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService());

        return http.build();
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(){
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

}
