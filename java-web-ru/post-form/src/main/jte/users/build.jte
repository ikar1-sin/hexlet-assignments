@template.layout.page(
    content = @`
    <form action="/users" method="post">
        <div>
            <label>
                Firstname:
                <input type="text" name="firstName">
            </label>
        </div>
        <div>
            <label>
                Lastname:
                <input type="text" name="lastName">
            </label>
        </div>
        <div>
            <label>
                Email:
                <input type="email" name="email">
            </label>
        </div>
        <div>
            <label>
                Password:
                <input type="password" name="password">
            </label>
        </div>
        <input type="submit" value="Create">
    </form>
    `
)