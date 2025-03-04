@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <main>
            <div>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</div>
        </main>
    `
)
