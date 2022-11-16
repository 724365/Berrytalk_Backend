package we.woongchang.board.global.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import we.woongchang.board.domain.user.web.dto.response.UserResponseDto;

import java.util.Collection;

public class CustomUserDetails  extends User {

    private final UserResponseDto userResponseDto;

    public CustomUserDetails(UserResponseDto responseDto, Collection<? extends GrantedAuthority> authorities) {
        super(responseDto.getName(), responseDto.getPassword(), authorities);
        this.userResponseDto = responseDto;
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, we.woongchang.board.domain.user.entity.User user, UserResponseDto userResponseDto) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userResponseDto = userResponseDto;
    }
}
