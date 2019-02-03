package am.foolSec.example.thymeleafFoolSec.model;


import am.foolSec.example.thymeleafFoolSec.model.enums.Role;
import am.foolSec.example.thymeleafFoolSec.model.enums.State;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;


@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

}
