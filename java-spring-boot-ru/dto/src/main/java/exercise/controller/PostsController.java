package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired PostRepository postRepository;

    @GetMapping
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream()
                .map(this::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found."));
        return toDto(post);
    }


    private PostDTO toDto(Post post) {
        var comments = commentRepository.findByPostId(post.getId());
        var postDto = new PostDTO();
        postDto.setTitle(post.getTitle());
        postDto.setBody(post.getBody());
        postDto.setId(post.getId());
        postDto.setComments(toCommentDto(comments));
        return postDto;
    }

    private List<CommentDTO> toCommentDto (List<Comment> comments) {
        List<CommentDTO> commentDTOList = new ArrayList<>();
        var commentDto = new CommentDTO();
        comments.forEach(c -> {
            commentDto.setId(c.getId());
            commentDto.setBody(c.getBody());
            commentDTOList.add(commentDto);
        });
        return commentDTOList;
    }

}
// END
