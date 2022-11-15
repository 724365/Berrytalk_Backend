package we.woongchang.board.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.woongchang.board.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_title", length = 20)
    private String title;

    @Column(name = "post_content")
    @Lob
    private String content;

    @Column(name = "post_wirter", length = 6)
    private String writer;

    @Column(name = "psot_serch")
    private int search;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;

    @Builder
    public Post(String title, String content, String writer, int search, User user) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.search = search;
        this.user = user;
    }
}
