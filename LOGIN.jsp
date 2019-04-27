<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baby Gambles</title>
    </head>
    <body>
        <h1>Baby Gambles</h1>
        <form action="BetPage.jsp" method="post">
            <input type="hidden" name="action" value="add">
            <label> Email: </label>
            <input type="text" name="FirstName" required><br>
            <label> Password: </label>
            <input type="text" name ="LastName" required><br>
            <input type="submit" value="Submit" id="submit">
        </form>
        <form action="SIGNUP.jsp">
            <input type="submit" value="Sign Up">
        </form>
    </body>
</html>
