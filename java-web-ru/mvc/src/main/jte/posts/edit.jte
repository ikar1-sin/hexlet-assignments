@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(
    content = @`
    <ul>
        @if(page.getErrors() != null)
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        @endif
    </ul>
    <form action="/posts/${page.getId()}" method="post">
        <div>
            <label>
                Title
                <input type="text" name="name" value="${page.getName()}">
            </label>
        </div>
        <div>
            <label>
                Content
                <textarea name="body" id="" cols="30" rows="10">${page.getBody()}</textarea>
            </label>
        </div>
        <input type="submit" value="Edit">
    </form>
    `
)