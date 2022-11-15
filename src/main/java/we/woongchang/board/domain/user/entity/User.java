package we.woongchang.board.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.woongchang.board.domain.post.entity.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name",nullable = false, length = 6)
    private String name;

    @Column(name = "user_email",nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false, length = 20)
    private String password;

    @Builder
    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "member", fetch = LAZY)
    private List<Post> postList = new ArrayList<>();

    public void postUpdate(Post newPost){
        postList.add(newPost);
    }
}
