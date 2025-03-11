@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(page.getPosts().isEmpty())
        <p>There are no posts</p>
    @else
        @for(var page : page.getPosts())
            <h3>${page.getName()}</h3>
            <p>${page.getBody()}</p>
        @endfor
    @endif
    `
)