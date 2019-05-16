/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rishav Saxena
 */
@WebServlet(urlPatterns = {"/UpdateProfile"})
public class UpdateProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        User user=new User();
        user.setName(request.getParameter("uname"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setAddress(request.getParameter("address"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("pass"));
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<body>");
            if(user.updateDatabase(request.getSession().getAttribute("email").toString())==0)
                out.println("<h3>Error in Updation of Profile</h3>");
            else
                out.println("<h3>Successfully Updated the profile</h3>");
            out.println("</body>");
            out.println("</html>");
            HttpSession session=request.getSession();
            session.removeAttribute("email");
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
        catch(Exception e)
        {
            System.out.println(e);
            response.sendRedirect("account.jsp");
        }  
    }

}
