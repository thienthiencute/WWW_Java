package fit.iuh.thanhoangthienthien_tuan07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    // Bean mã hóa mật khẩu
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Tạo 3 tài khoản người dùng trong bộ nhớ
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails customer = User.builder()
                .username("customer")
                .password(encoder.encode("111"))
                .roles("CUSTOMER")
                .build();

        UserDetails guest = User.builder()
                .username("guest")
                .password(encoder.encode("guest"))
                .roles("GUEST")
                .build();

        return new InMemoryUserDetailsManager(admin, customer, guest);
    }

    // Cấu hình bảo mật cho hệ thống
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Cho phép truy cập static resources và trang login/logout
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/login", "/logout").permitAll()

                        // Phân quyền truy cập theo role
                        .requestMatchers("/products", "/products/detail/**","/products/search").hasAnyRole("CUSTOMER", "ADMIN","GUEST")
                        .requestMatchers("/products/add", "/products/edit/**", "/products/update/**").hasRole("ADMIN")
                        .requestMatchers("/orders/**").hasRole("ADMIN")
                        .requestMatchers("/customers/**").hasRole("ADMIN")
                        .requestMatchers("/categories/**").hasRole("ADMIN")
                        // Các request khác yêu cầu đăng nhập
                        .anyRequest().authenticated()
                )

                // Cấu hình form đăng nhập tùy chỉnh
                .formLogin(form -> form
                        .loginPage("/login")               // Trang login tùy chỉnh
                        .loginProcessingUrl("/login")      // URL xử lý form login
                        .defaultSuccessUrl("/home", true) // Chuyển hướng sau khi login thành công
                        .permitAll()
                )

                // Cấu hình logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )

                // Tắt CSRF (nếu không dùng form POST khác)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
