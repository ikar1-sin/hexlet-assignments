@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    content = @`
    <ul>
        @for(var post : page.getPosts())
            <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
        @endfor
    </ul>
    <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPage() - 1)}">Previous</a>
    <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPage() + 1)}">Next</a>
    `
)
