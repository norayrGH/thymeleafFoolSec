package am.foolSec.example.thymeleafFoolSec.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Controller
public class ProfileController {
    @RequestMapping(value = "/")
    public String getProfilePage(HttpServletResponse response){
        String cacheControl = CacheControl.maxAge(10, TimeUnit.SECONDS).getHeaderValue();
        response.addHeader("Cache-Control", cacheControl);
        return "profile";
    }
}
