package clinix.com.clinix_sistema_usuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/")
    public String showHomePage() {
        return "form";

    }

}
