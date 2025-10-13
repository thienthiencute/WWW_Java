package fit.iuh.thanhoangthienthien_tuan07.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome Thymeleaf");
        model.addAttribute("date", LocalDate.now().toString());
        return "home";
    }
}
