package we.woongchang.board.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import we.woongchang.board.domain.user.User;

@Repository
public class MemberRepository extends JpaRepository<User, Long> {

}
