@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator: page.getErrors().values())
                @for(var error : validator)
                    <h3>${error.getMessage()}</h3>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <div>
            <label>
                Title:
                <input type="text" required name="title" value="${page.getTitle()}">
            </label>
        </div>
        <div>
            <label>
                Content:
                <textarea required name="content">${page.getContent()}</textarea>
            </label>
        </div>
        <input type="submit" value="Make a post">
    </form>
    `
)