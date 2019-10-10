package am.foolSec.example.thymeleafFoolSec.service;


import am.foolSec.example.thymeleafFoolSec.dto.SignUpUserDTO;
import am.foolSec.example.thymeleafFoolSec.model.User;
import am.foolSec.example.thymeleafFoolSec.model.enums.Role;
import am.foolSec.example.thymeleafFoolSec.model.enums.State;
import am.foolSec.example.thymeleafFoolSec.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpUserDTO signUpUserDTO) {

        User user = User.builder()
                .login(signUpUserDTO.getUsername())
                .hashPassword(passwordEncoder.encode(signUpUserDTO.getPassword()))
                .role(Role.ROLE_USER)
                .state(State.ACTIVE).build();
        userRepository.save(user);

    }
}
