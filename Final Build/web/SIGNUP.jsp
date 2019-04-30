<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
        <%-- \This will be used to allow the user to create an account with our web page.
               Each one of these statements correlates to a column in our database.--%>
    </head>
    <body>
        <h1>Sign up:</h1>
         <form action = "BabyGambles" method ="get" />
         <%--This get request is used to send the information to that page and
            begin setting the information to the game.--%>
            <input type="hidden" name="action" value="add">
            <label>First Name:  </label> 
            <input type="text" name ="FirstName" required><br>
            <%-- Each of these text boxes are represented by the words above them
            and by the text type.--%>
            <label>Last Name:   </label> 
            <input type="text" name ="LastName" required><br>
            <label>Credit Card: </label>
            <input type="text" name ="CreditCard" required><br>
            <label>Email:       </label> 
            <input type="text" name ="Email" required> <br>
            <label>Password:    </label>
            <input type="text" name ="Password" required> <br>
            <input type="submit" value="submit now">
            <%-- This submit button allows the information typed in to be sent and 
            action to be sent--%>
    </body>
</html>
