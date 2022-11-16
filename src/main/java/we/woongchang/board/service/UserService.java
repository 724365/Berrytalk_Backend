package we.woongchang.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.woongchang.board.domain.user.entity.User;
import we.woongchang.board.domain.user.entity.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;


    // id로 조회
    public Optional<User> findById(Long id) {
        Optional<User> findUser = userRepository.findById(id);
        return findUser;
    }

    // email로 조회
    public Optional<User> findByEmail(String email) {
        Optional<User> findUser = userRepository.findByEmail(email);
        return findUser;
    }

    // 전체 조회
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // 회원 수정
    public void update(Long id, String name, String password) {
        Optional<User> findUser = userRepository.findById(id);

        User updateUser = User.builder()
                .name(name)
                .password(password)
                .build();
    }
}
