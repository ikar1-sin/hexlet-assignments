package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


// BEGIN
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsPage {
    private List<Post> posts;
    private Integer page;
}
// END


