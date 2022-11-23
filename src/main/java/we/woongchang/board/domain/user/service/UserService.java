package we.woongchang.board.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.woongchang.board.domain.user.entity.User;
import we.woongchang.board.domain.user.entity.repository.UserRepository;
import we.woongchang.board.domain.user.entity.role.UserRole;
import we.woongchang.board.domain.user.web.dto.request.UserSignupRequestDto;
import we.woongchang.board.global.exception.CustomException;
import we.woongchang.board.global.exception.ErrorCode;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


        public void signup(UserSignupRequestDto userSignupRequestDto){
        userRepository.findByEmail(userSignupRequestDto.getEmail()).orElseThrow(() -> new CustomException(ErrorCode.ALREADY_EXISTS_USER));

        User user = new User(userSignupRequestDto.getName(), userSignupRequestDto.getEmail(), passwordEncoder.encode(userSignupRequestDto.getPassword()), UserRole.USER);

        userRepository.save(user);
    }
}
