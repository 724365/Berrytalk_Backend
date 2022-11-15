package we.woongchang.board.domain.post.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import we.woongchang.board.domain.post.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.title =: _title_")
    List<Post> findByTitle(String title);

    @Query("select p from Post p order by p.view desc , p.createdTime asc")
    List<Post> findAll();
}
