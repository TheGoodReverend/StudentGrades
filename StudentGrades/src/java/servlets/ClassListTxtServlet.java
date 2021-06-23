/**
 *
 * @author KBowe
 */
package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClassListTxtServlet extends HttpServlet 
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg="", URL="/ClassList.jsp";
        ArrayList<Student> stulist = null;
        
        
        try
        {
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/Classlist.txt");
            
            stulist = StudentIO.getStudents(path);
            if(stulist.size() == 0)
            {
                throw new Exception("Stulist Returned empty");
            }
            request.setAttribute("stulist", stulist);
        }
        catch(Exception e)
        {
            msg += "Class list servlet error " + e.getMessage() + "<br>";
            request.setAttribute("msg", msg);
        }
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        
        disp.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
