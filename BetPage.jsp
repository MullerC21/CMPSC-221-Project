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
        <form action="BabyGambles" method="post">
            <input type="hidden" name="action" value="bet">
            <label><b>Bet Amount:</b></label>
            <input type="text" name ="currency"  required>
            <input type="submit" value="Bet"/>
        </form>
    </body>
</html>
