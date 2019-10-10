package am.foolSec.example.thymeleafFoolSec.controller;


import am.foolSec.example.thymeleafFoolSec.dto.SignUpUserDTO;
import am.foolSec.example.thymeleafFoolSec.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class SignUpController {

    @Autowired
    SignUpServiceImpl signUpService;

    @PostMapping(value = "/signup")
    public ResponseEntity.BodyBuilder signUp(@RequestBody SignUpUserDTO signUpUserDTO){
        try {
            signUpService.signUp(signUpUserDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest();
        }
        return ResponseEntity.ok();

    }
    @GetMapping(value = "/signup")
    public String signUp(){

        return "signup";
    }
}
