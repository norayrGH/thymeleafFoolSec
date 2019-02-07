package am.foolSec.example.thymeleafFoolSec.security.configs.detiles;


import am.foolSec.example.thymeleafFoolSec.model.User;
import am.foolSec.example.thymeleafFoolSec.model.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String userRole = user.getRole().name();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole);
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {return !user.getState().equals(State.BANNED); }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.ACTIVE);
    }
}
