package by.tms.job_finder.config;

import by.tms.job_finder.model.account.AccountRole;
import by.tms.job_finder.model.token.AccessTokenProperties;
import by.tms.job_finder.service.auth.AccessTokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AccessTokenService accessTokenService) throws Exception {
        return httpSecurity
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(config -> config.disable())
                .authorizeHttpRequests(config -> config
                        .requestMatchers("/candidate/**").hasRole(AccountRole.CANDIDATE.name())
                        .requestMatchers("/employer/**").hasRole(AccountRole.EMPLOYER.name())
                        .requestMatchers("/vacancy/**").permitAll()
                        .requestMatchers("/info/**").permitAll()
                        .anyRequest().denyAll()
                )
                .addFilterAfter(new AccessTokenAuthenticationFilter(accessTokenService), BasicAuthenticationFilter.class)
                .build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    Algorithm jwtAlgorithm(AccessTokenProperties props) {
        return Algorithm.HMAC256(props.getSecret());
    }

    @Bean
    JWTVerifier jwtVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).build();
    }


}
