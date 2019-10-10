package am.foolSec.example.thymeleafFoolSec.controller;



import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {

    @RequestMapping("/login")

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
