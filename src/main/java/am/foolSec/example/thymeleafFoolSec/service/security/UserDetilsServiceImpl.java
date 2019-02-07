package am.foolSec.example.thymeleafFoolSec.service.security;


import am.foolSec.example.thymeleafFoolSec.repository.UserRepository;
import am.foolSec.example.thymeleafFoolSec.security.configs.detiles.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserDetilsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       return new UserDetailsImpl(userRepository.findOneByLogin(login).orElseThrow(IllegalArgumentException::new));
    }
}
