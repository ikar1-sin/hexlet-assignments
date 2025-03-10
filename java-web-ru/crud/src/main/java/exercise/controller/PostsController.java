package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {

    // BEGIN
    public static void showArticle(Context ctx) {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Not found user"));
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.findAll(pageNumber, 5);
        var page = new PostsPage(posts, pageNumber);
        ctx.render("posts/index.jte", model("page", page));
    }
    // END
}
