package we.woongchang.board.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.woongchang.board.domain.post.entity.Post;
import we.woongchang.board.domain.user.entity.role.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<Post> postList = new ArrayList<>();

    @Builder
    public User(String name, String email, String password, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public void postUpdate(Post newPost){
        postList.add(newPost);
    }
}
