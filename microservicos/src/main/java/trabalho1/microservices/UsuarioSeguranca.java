package trabalho1.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UsuarioSeguranca {

    @Autowired
    private jwtConversor conversor;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.GET, "/usuario/token").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuario").permitAll()
                .requestMatchers(HttpMethod.PUT, "/usuario").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuario/bloqueados").permitAll()
                .requestMatchers("/usuario/desbloquear/**").hasRole("ADMIN"))
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(conversor)));

        return http.build();
    }

    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        System.out.println(passwordEncoder.encode("password"));

        UserDetails usuario = User.withUsername("user").password(passwordEncoder.encode("password")).roles("USUARIO").build();

        UserDetails administrador = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USUARIO", "ADMIN").build();

        return new InMemoryUserDetailsManager(usuario, administrador);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

