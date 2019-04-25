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
        <p>How to Play: Enter the amount you wish to bet, then simply click the "Roll" button below. If your first roll is a 7 or 11, you win the game. If it is a 2, 3, or 12, you lose. If it is any other roll, you must roll the dice again until you either match the first roll's value or roll a 7, which means you lose</p>
        
        <form>
            <label><b>Bet Amount:</b></label>
            <input type="text" id="userInput"/>
            <input type="button" value="Submit" onclick="document.getElementById('userInput').disabled = true;"/>
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
