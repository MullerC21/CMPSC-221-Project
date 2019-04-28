<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baby Gambles</title>
    </head>
    <body>
        <h1>Baby Gambles</h1>
        <form action="BabyGambles" method="post">
            <input type="hidden" name="action" value="login">
            <label> Email: </label>
            <input type="text" name="Email" required><br>
            <label> Password: </label>
            <input type="text" name ="Password" required><br>
            <input type="submit" value="Log In">
        </form>
        <form action="BabyGambles" method="post">
            <input type="hidden" name="action" value="signup">
            <input type="submit" value="Sign Up">
        </form>
    </body>
</html>
