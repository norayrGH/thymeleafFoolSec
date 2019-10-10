package am.foolSec.example.thymeleafFoolSec.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class SignUpUserDTO implements Serializable {
    private String username;
    private String password;

}
