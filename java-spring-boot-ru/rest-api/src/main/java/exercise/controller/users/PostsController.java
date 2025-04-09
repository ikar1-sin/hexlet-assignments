package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api/users/{id}")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/posts")
    public List<Post> index(@PathVariable String id) {
        var page = posts.stream()
                .filter(p -> p.getUserId() == Integer.parseInt(id))
                .toList();
        return page;
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post data, @PathVariable int id) {
        data.setUserId(id);
        posts.add(data);
        return data;
    }

}
// END
