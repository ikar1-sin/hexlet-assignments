@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
    @if(page != null)
        <div>
            ${page.getError()}
        </div>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <div>
            <label>
                Username:
                <input type="text" placeholder="Username" required name="name">
            </label>
        </div>
        <div>
            <label>
                Password:
                <input type="password" placeholder="Password" required name="password">
            </label>
        </div>
        <input type="submit" value="Log in">
    </form>
    `
)