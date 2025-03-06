@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    @if(page.getTerm() == null)
        @for(var user : page.getUsers())
            <h2>${user.getFirstName()} ${user.getLastName()} ${user.getEmail()}</h2>
        @endfor
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
    @else
        @for(var user : page.getUsers())
            <h2>${user.getFirstName()} ${user.getLastName()} ${user.getEmail()}</h2>
        @endfor
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
    @endif
    `
)