<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Classes.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Page</title>
    </head>
    <script>
        /*
         * Generates two random numbers between 1 and 6 (Roll1 and Roll2)
         * The total value of the roll is the sum of Roll1 and Roll2
         * The logic of when the user wins or loses is contained in this function
         */ 
        function diceRollFunction() {
  
            var minNumber = 1; // The minimum number you want
            var maxNumber = 6; // The maximum number you want
            var Roll1 = Math.floor(Math.random() * maxNumber + minNumber); // Generates random number
            var Roll2 = Math.floor(Math.random() * maxNumber + minNumber); // Generates random number
            
            var RollTotal = Roll1 + Roll2;
             /*
             * The if and else if statements below call a web source to an image field.
             * This is used for the user to see their result with an image for both
             * roll one and roll two.
             */
            // assign correct image depending on the value of Roll1
            if(Roll1 === 1) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll1 === 2) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll1 === 3) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll1 === 4) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll1 === 5) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll1 === 6) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            // assign correct image depending on the value of Roll2
            if(Roll2 === 1) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll2 === 2) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll2 === 3) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll2 === 4) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll2 === 5) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll2 === 6) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            // display value of current roll
            alert("You rolled a " + Roll1 + " and a " + Roll2 + ", giving your roll a total value of " + RollTotal);
            
            // user wins
            if (RollTotal === 7 || RollTotal === 11) {
                alert("You win!");
            }
            
            // user loses
            else if (RollTotal === 2 || RollTotal === 3 || RollTotal === 12) {
                alert("You lose!");
            }
            
            // user must roll again
            else {
                alert("You must roll again!");
                diceRollFunction(); // recursive call
            }
           
        }
    </script>
    <body>
        <h1>Game Page</h1>
        
        <!-- explanation of how to play -->
        <p>How to Play: Click the "Roll" button below to begin. If your roll is a 7 or 11, you win; if it is a 2, 3, or 12, you lose. If it is any other value, you must roll the dice again.</p>
        
        <!-- roll button functionality -->
        <form action="GamePage.jsp" method="post">
            <input type="button" onclick="diceRollFunction()" value="Roll"/><br>
        </form>
        
        <!-- spacing -->
        <br><br>
        
        <!-- image for Roll1 -->
        <image id="Dice1">
        
        <!-- image for Roll2 -->
        <image id="Dice2">
        
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        
        <!-- returns user to the betting page if they wish to play again -->
        <form action="BetPage.jsp">
            <input type="submit" value="Play Again!"/>
        </form>
        
        <!-- spacing -->
        <br>
        
        <!-- returns user to the login page if they wish to sign out -->
        <form action="BabyGambles">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Sign Out"/> 
        </form>
        
    </body> 
</html>