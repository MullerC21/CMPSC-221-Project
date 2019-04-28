<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
    </head>
    <body>
        <h1>That Email is already in use!</h1>
        <form action = "BabyGambles" method ="get">
            <input type="hidden" name="action" value="return">
            <input type="submit" value="Return to Login Page"/>
        </form>
        <h1>Sign up:</h1>
         <form action = "BabyGambles" method ="get">
            <input type="hidden" name="action" value="add">
            <label>First Name:  </label> 
            <input type="text" name ="FirstName"><br>
            <label>Last Name:   </label> 
            <input type="text" name ="LastName"><br>
            <label>Credit Card: </label>
            <input type="text" name ="CreditCard"><br>
            <label>Email:       </label> 
            <input type="text" name ="Email"> <br>
            <label>Password:    </label>
            <input type="text" name ="Password"> <br>
            <input type="submit" value="submit now">
         </form>
    </body>
</html>
