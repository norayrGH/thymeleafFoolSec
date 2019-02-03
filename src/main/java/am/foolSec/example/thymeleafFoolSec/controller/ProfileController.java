package am.foolSec.example.thymeleafFoolSec.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping(value = "/")
    public String getProfilePage(Authentication authentication){

        return "profile";
    }
}
