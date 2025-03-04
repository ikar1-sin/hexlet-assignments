@import exercise.dto.users.UsersPage
@param UsersPage pages

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<div>
    <main>
        @if(pages.getUsers().isEmpty())
            <p>There are no users</p>
        @else
            @for(var user : pages.getUsers())
                <div>
                    <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                </div>
            @endfor
        @endif
    </main>
</div>
</body>
</html>