<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baby Gambles</title>
           <%--This is the first page that is opened for our web application.
           It seems appropriate to label it with the name of our game, and 
           with our text boxes below one can pull from the database their previous
           information. By placing their login information their amount of money
           credit card, and all other information are pulled from the database.--%>
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
            <%-- This submit button allows the action to be take place.  
           This redirects to the BetPage.JSP that allows the user to set their 
            bet for that round of Baby Gambles--%>
        </form>
        <form action="SIGNUP.jsp">
            <input type="submit" value="Sign Up">
            <%-- This action allows a new user to insert their information into
            our database.--%>
        </form>
    </body>
</html>
