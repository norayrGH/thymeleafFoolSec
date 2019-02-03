package am.foolSec.example.thymeleafFoolSec.service;


import am.foolSec.example.thymeleafFoolSec.dto.SignUpUserDTO;
import am.foolSec.example.thymeleafFoolSec.model.User;
import am.foolSec.example.thymeleafFoolSec.model.enums.Role;
import am.foolSec.example.thymeleafFoolSec.model.enums.State;
import am.foolSec.example.thymeleafFoolSec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpUserDTO signUpUserDTO) {

        User user = User.builder()
                .login(signUpUserDTO.getEmail())
                .hashPassword(passwordEncoder.encode(signUpUserDTO.getPassword()))
                .role(Role.USER)
                .state(State.ACTIVE).build();
        userRepository.save(user);

    }
}
