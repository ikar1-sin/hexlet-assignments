@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @for(var user : page.getUsers())
            <h2>${user.getFirstName()} ${user.getLastName()}</h2>
        @endfor
    `
)
