package am.foolSec.example.thymeleafFoolSec.controller;



import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(Authentication authentication){

        if(authentication == null)
        {


        }
        return "login";
    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
