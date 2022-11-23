package we.woongchang.board.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import we.woongchang.board.domain.user.entity.User;
import we.woongchang.board.domain.user.entity.repository.UserRepository;
import we.woongchang.board.domain.user.entity.role.UserRole;
import we.woongchang.board.domain.user.web.dto.request.UserSignupRequestDto;
import we.woongchang.board.global.exception.CustomException;
import we.woongchang.board.global.exception.ErrorCode;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Transactional
    public Long signup(UserSignupRequestDto request) throws Exception {

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new CustomException(ErrorCode.ALREADY_EXISTS_USER);
        }

        User user = userRepository.save(request.toEntity());
        user.passwordEncode(passwordEncoder);
        user.addUserAuthority();

        return user.getId();
    }
}
