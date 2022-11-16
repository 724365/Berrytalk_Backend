package we.woongchang.board.domain.user.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import we.woongchang.board.domain.user.entity.User;

@Getter
public class UserResponseDto {

    private String name;

    private String email;

    private String password;

    @Builder
    public UserResponseDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
