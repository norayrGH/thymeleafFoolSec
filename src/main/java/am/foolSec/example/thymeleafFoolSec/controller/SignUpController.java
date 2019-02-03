package am.foolSec.example.thymeleafFoolSec.controller;


import am.foolSec.example.thymeleafFoolSec.dto.SignUpUserDTO;
import am.foolSec.example.thymeleafFoolSec.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "/signup")
public class SignUpController {

    @Autowired
    SignUpServiceImpl signUpService;

    @PostMapping(value = ""
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
            ,produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public String signUp(SignUpUserDTO signUpUserDTO){
        signUpService.signUp(signUpUserDTO);

        return "login";
    }
    @GetMapping(value = "")
    public String signUp(){

        return "signup";
    }
}
