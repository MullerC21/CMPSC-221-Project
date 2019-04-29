<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
        <%-- \This will be used to allow the user to create an account with our web page.
               Each one of these statements correlates to a column in our database.--%>
    </head>
    <body>
        <h1>That Email is already in use!</h1>
        <form action = "BabyGambles" method ="get">
            <input type="hidden" name="action" value="return">
            <input type="submit" value="Return to Login Page"/>
        </form>
        <h1>Sign up:</h1>
         <form action = "BabyGambles" method ="get">
             <%--This get request is used to send the information to that page and
            begin setting the information to the game.--%>
            <input type="hidden" name="action" value="add">
            <label>First Name:  </label> 
            <input type="text" name ="FirstName"><br>
            <%-- Each of these text boxes are represented by the words above them
            and by the text type.--%>
            <label>Last Name:   </label> 
            <input type="text" name ="LastName"><br>
            <label>Credit Card: </label>
            <input type="text" name ="CreditCard"><br>
            <label>Email:       </label> 
            <input type="text" name ="Email"> <br>
            <label>Password:    </label>
            <input type="text" name ="Password"> <br>
            <input type="submit" value="submit now">
            <%-- This submit button allows the information typed in to be sent and 
            action to be sent--%>
         </form>
    </body>
</html>
