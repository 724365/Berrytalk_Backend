package we.woongchang.board.domain.user.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import we.woongchang.board.domain.user.entity.User;
import we.woongchang.board.domain.user.entity.role.UserRole;

@Getter
public class UserResponseDto {

    private String name;

    private String email;

    private String password;

    private UserRole userRole;

    @Builder
    public UserResponseDto(String name, String email, String password, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
