package we.woongchang.board.domain.user.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import we.woongchang.board.domain.user.entity.repository.UserRepository;
import we.woongchang.board.domain.user.service.UserService;
import we.woongchang.board.domain.user.web.dto.request.UserSignupRequestDto;
import we.woongchang.board.domain.user.web.dto.response.UserResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Enumeration;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public Long signup(@Valid @RequestBody UserSignupRequestDto userSignupRequestDto) throws Exception {
        return userService.signup(userSignupRequestDto);
    }
}


