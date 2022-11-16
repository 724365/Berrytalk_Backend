package we.woongchang.board.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.woongchang.board.domain.post.entity.repository.PostRepository;
import we.woongchang.board.domain.user.entity.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


}
