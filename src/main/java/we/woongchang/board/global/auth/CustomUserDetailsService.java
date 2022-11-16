package we.woongchang.board.global.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import we.woongchang.board.domain.user.entity.User;
import we.woongchang.board.domain.user.entity.repository.UserRepository;
import we.woongchang.board.domain.user.web.dto.response.UserResponseDto;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(UserResponseDto :: new)
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"))
    }
}
