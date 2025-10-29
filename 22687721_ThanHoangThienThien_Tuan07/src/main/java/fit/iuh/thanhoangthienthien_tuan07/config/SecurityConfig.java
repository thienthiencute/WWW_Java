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

    /**
     * Bean mã hóa mật khẩu bằng BCrypt
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Cấu hình người dùng trong bộ nhớ (In-Memory Authentication)
     */
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

    /**
     * Cấu hình phân quyền và bảo mật URL cho ứng dụng
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Cho phép truy cập các static resource và ảnh upload
                .requestMatchers("/css/**", "/js/**", "/images/**", "/uploads/**").permitAll()

                // Các trang công khai
                .requestMatchers("/", "/home", "/login").permitAll()

                // Trang sản phẩm: cho phép CUSTOMER, ADMIN, GUEST
                .requestMatchers("/products", "/products/detail/**", "/products/search")
                .hasAnyRole("CUSTOMER", "ADMIN", "GUEST")

                // Quản lý sản phẩm: chỉ ADMIN
                .requestMatchers("/products/add", "/products/edit/**", "/products/delete/**")
                .hasRole("ADMIN")

                // Giỏ hàng và thanh toán: CUSTOMER hoặc ADMIN
                .requestMatchers("/orders/cart/**", "/orders/checkout")
                .hasAnyRole("CUSTOMER", "ADMIN")

                // Quản lý đơn hàng, khách hàng: chỉ ADMIN
                .requestMatchers("/orders/**", "/customers/**")
                .hasRole("ADMIN")

                // Các yêu cầu khác phải đăng nhập
                .anyRequest().authenticated()
            )

            // Form đăng nhập mặc định của Spring Security
            .formLogin(form -> form
                .defaultSuccessUrl("/products", true)
                .permitAll()
            )

            // Cấu hình logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
}
