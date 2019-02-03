package am.foolSec.example.thymeleafFoolSec.controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginPage(Authentication authentication){
        if(authentication != null)
            return "redirect:/";

        return "login";
    }
}
