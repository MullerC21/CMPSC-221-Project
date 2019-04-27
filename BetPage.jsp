<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Betting Page</title>
    </head>
    <body>
        <h1>Betting Page</h1>
        <p>Please enter the amount you wish to bet:</p><br>
        <form action="GamePage.jsp" method="post">
            <label><b>Bet Amount:</b></label>
            <input type="text" id="userInput"/>
            <input type="submit"/>
        </form>
    </body>
</html>
