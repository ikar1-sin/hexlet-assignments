@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page.getName() != null)
        <h3>Welcome: ${page.getName().toString()}</h3>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
    @endif    
`)