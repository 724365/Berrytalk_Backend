package we.woongchang.board.domain.user.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSignupRequestDto {

    private String name;

    private String email;

    private String password;

    @Builder
    public UserSignupRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
