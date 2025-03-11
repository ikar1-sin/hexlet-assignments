@import gg.jte.Content
@import exercise.dto.BasePage
@param BasePage page = null
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <main>
        @if(page != null && page.getFlash() != null)
            <div>
                ${page.getFlash()}
            </div>
        @endif
        ${content}
    </main>
</body>
</html>
