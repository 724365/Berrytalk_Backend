package we.woongchang.board.domain.user.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.woongchang.board.domain.user.entity.repository.UserRepository;
import we.woongchang.board.domain.user.service.UserService;
import we.woongchang.board.domain.user.web.dto.request.UserSignupRequestDto;
import we.woongchang.board.domain.user.web.dto.response.UserResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserSignupRequestDto userSignupRequestDto){

        userService.signup(userSignupRequestDto);
    }
}
