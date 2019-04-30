package Classes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class UserController extends HttpServlet 
{
    UserDB user = new UserDB();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = "/LOGIN.jsp";
        
        String action = request.getParameter("action");
        if(action == null)
        {
            action = "join";
        }
        if(action.equals("join") || action.equals("return"))
        {
            url = "/LOGIN.jsp";
        }
        if(action.equals("login"))
        {
            url = "/BetPage.jsp";
        }
        if(action.equals("bet"))
        {
            url = "/GamePage.jsp";
        }
        if(action.equals("signup"))
        {
            url = "/SIGNUP.jsp";
        }
        else if(action.equals("add"))
        {
            String email = request.getParameter("Email");
            String firstName = request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            String password = request.getParameter("Password");
            int creditCard = Integer.parseInt(request.getParameter("CreditCard"));
            
            int inttest;
            inttest = user.insert(email, firstName, lastName, password, creditCard);
            
            switch(inttest)
            {
                case 0: 
                    url = "/SIGNUPerror.jsp";
                    break;
                case 1:
                    url = "/BetPage.jsp";
                    break;
            }
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }
}
