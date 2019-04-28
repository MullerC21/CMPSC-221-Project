<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Classes.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Page</title>
    </head>
    <script>
        function diceRollFunction() {
            
            var Roll1 = <%= RollDice.roll_dice()%>;
            var Roll2 = <%= RollDice.roll_dice()%>;
            var RollTotal = Roll1 + Roll2;
            
            if(Roll1 === 1) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll1 === 2) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll1 === 3) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll1 === 4) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll1 === 5) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll1 === 6) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            if(Roll2 === 1) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll2 === 2) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll2 === 3) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll2 === 4) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll2 === 5) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll2 === 6) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            alert("You rolled a " + Roll1 + " and a " + Roll2 + ", giving your roll a total value of " + RollTotal);
            
            if (RollTotal === 7 || RollTotal === 11) {
                alert("You win!");
            }
            
            else if (RollTotal === 2 || RollTotal === 3 || RollTotal === 12) {
                alert("You lose!");
            }
            
            else {
                alert("You must roll again!");
                diceRollFunction();
            }
            
        }
    </script>
    <script>
        function diceRollFunction2() {
            
            var minNumber = 1; // The minimum number you want
            var maxNumber = 6; // The maximum number you want
            var Roll1 = Math.floor(Math.random() * (maxNumber) + minNumber); // Generates random number
            var Roll2 = Math.floor(Math.random() * (maxNumber) + minNumber); // Generates random number
            
            var RollTotal = Roll1 + Roll2;
            
            if(Roll1 === 1) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll1 === 2) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll1 === 3) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll1 === 4) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll1 === 5) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll1 === 6) document.getElementById('Dice1').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            if(Roll2 === 1) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/1c.gif";
            else if(Roll2 === 2) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/2c.gif";
            else if(Roll2 === 3) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/3c.gif";
            else if(Roll2 === 4) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/4c.gif";
            else if(Roll2 === 5) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/5c.gif";
            else if(Roll2 === 6) document.getElementById('Dice2').src = "http://dobbelsteen.virtuworld.net/img/6c.gif";
            
            alert("You rolled a " + Roll1 + " and a " + Roll2 + ", giving your roll a total value of " + RollTotal);
            
            if (RollTotal === 7 || RollTotal === 11) {
                alert("You win!");
            }
            
            else if (RollTotal === 2 || RollTotal === 3 || RollTotal === 12) {
                alert("You lose!");
            }
            
            else {
                alert("You must roll again!");
                diceRollFunction2();
            }
            
        }
    </script>
    <script>
        var link = document.getElementById('getNumber'); // Gets the link
        link.onclick = getNumber; // Runs the function on click

        function getNumber() {
        var minNumber = 0; // The minimum number you want
        var maxNumber = 100; // The maximum number you want
        var randomnumber = Math.floor(Math.random() * (maxNumber + 1) + minNumber); // Generates random number
        $('#myNumber').html(randomnumber); // Sets content of <div> to number
        return false; // Returns false just to tidy everything up
}
    </script>
    <body>
        <h1>Game Page</h1>
        <p>How to Play: Click the "Roll" button below to begin. If your first roll is a 7 or 11, you win; if it is a 2, 3, or 12, you lose. If it is any other value, you must roll the dice repeatedly until you either match the first roll's value, in which case you win, or roll a 7, in which case you lose.</p>
        
        <!--<div id="myNumber"></div> <!-- Your number will appear in here -->
        <!--<a href="no-javascript.html" id="getNumber">Get number</a> <!-- Link to get number. If the user has no JS enabled it will redirect to no-javascript.html -->
        
        <form action="GamePage.jsp" method="post">
            <input type="button" onclick="diceRollFunction2()" value="Roll"/><br>
        </form>
        
        <image id="Dice1">
        
        <image id="Dice2">
        
        
        
        
        
        
        
        
        
        <br><br><br><br><br><br><br>
        <form action="BetPage.jsp">
            <input type="submit" value="Play Again!"/>
        </form>
        
        <form action="BabyGambles">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Sign Out"/> 
        </form>
        
        
    </body> 
</html>
