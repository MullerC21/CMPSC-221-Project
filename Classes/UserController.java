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
            user.setEmail(request.getParameter("Email"));
            url = "/BetPage.jsp";
        }
        if(action.equals("bet"))
        {
            int currency = Integer.parseInt(request.getParameter("currency"));
            user.updateCurrency(currency);
            
            url = "/GamePage.jsp";
        }
        if(action.equals("signup"))
        {
            url = "/SIGNUP.jsp";
        }
        else if(action.equals("add"))
        {
            user.setEmail(request.getParameter("Email"));
            String firstName = request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            String password = request.getParameter("Password");
            double currency = 0.0;
            int creditCard = Integer.parseInt(request.getParameter("CreditCard"));
            
            int inttest;
            inttest = user.insert(user.getEmail(), firstName, lastName, password, currency, creditCard);
            
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
