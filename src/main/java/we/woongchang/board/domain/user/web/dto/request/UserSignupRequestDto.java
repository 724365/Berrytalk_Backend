package we.woongchang.board.domain.user.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import we.woongchang.board.domain.user.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class UserSignupRequestDto {

    //@NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String name;

    // @NotBlank(message = "이메일은 필수 입력 값입니다.")
    //@Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

   // @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
  //  @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
     //       message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
