package fit.iuh.thanhoangthienthien_tuan07.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // Có thể cấu hình trong application.properties, mặc định là "uploads"
    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ánh xạ /uploads/** -> thư mục thật trên hệ thống
        String location = Paths.get(uploadDir).toAbsolutePath().toUri().toString(); // "file:/.../uploads/"
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations(location);
    }
}
