<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Page</title>
    </head>
    <script>
        function diceRollFunction() {
            
        }
    </script>
    <body>
        <h1>Game Page</h1>
        <p>How to Play: Enter the amount you wish to bet, then simply click the "Roll" button below. *INSERT RULES HERE*</p>
        
        <form>
            <label><b>Bet Amount:</b></label>
            <input type="text" id="userInput"/>
            <input type="button" value="submit" onclick="document.getElementById('userInput').disabled = true;"/>
        </form>
        
        <form action="GamePage.jsp" method="post">
            <input type="button" onclick="diceRollFunction()" value="Roll"/> 
        </form>
        
        
        
        <form action="GamePage.jsp">
            <input type="submit" value="Play Again!"/>
        </form>
        
        <form action="LoginPage.jsp">
            <input type="submit" value="Sign Out"/> 
        </form>
    </body>
</html>
