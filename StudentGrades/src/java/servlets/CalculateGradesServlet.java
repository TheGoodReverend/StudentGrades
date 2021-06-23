/**
 *
 * @author KBowen
 */
package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculateGradesServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "", URL = "/StudentGrade.jsp";
        Student s = null;
        
        try
        {
            s = new Student();
            
            String sid = request.getParameter("sid");
            
            if(sid.trim().isEmpty())
            {
                msg += " Missing Student ID. <br>";
            }
            else
            {
                s.setSid(sid);
            }
            
            String lnm = request.getParameter("lastname");
            if(lnm.trim().isEmpty())
            {
                msg += " Missing Last Name. <br>";
            }
            else
            {
                s.setLname(lnm);
            }
            
            String fnm = request.getParameter("firstname");
            if(fnm.trim().isEmpty())
            {
                msg += " Missing First Name. <br>";
            }
            else
            {
                s.setFname(fnm);
            }
            
            String [] scores = { "q1", "q2", "q3", "q4", "q5", "qmkup", "midterm", "probs", "final"};
            
            for (String score : scores)
            {
                String scr = request.getParameter(score);
                
                try
                {
                    double sval = Double.parseDouble(scr);
                    if(sval < 0 || sval > 125)
                    {
                        throw new NumberFormatException (" out of bounds");
                    }
                    switch(score)
                    {
                        case "q1":
                            s.setQ1(sval);
                            break;
                        case "q2":
                            s.setQ2(sval);
                            break;
                        case "q3":
                            s.setQ3(sval);
                            break;
                        case "q4":
                            s.setQ4(sval);
                            break;
                        case "q5":
                            s.setQ5(sval);
                            break;
                        case "qmkup":
                            s.setQm(sval);
                            break;
                        case "midterm":
                            s.setMt(sval);
                            break;
                        case "probs":
                            s.setPr(sval);
                            break;
                        case "final":
                            s.setFe(sval);
                            break;
                    } //end of switch
                }
                catch (NumberFormatException e)
                {
                    msg += score + " error: " + e.getMessage() + "<br>";
                }
            }
            
            request.setAttribute("student", s);
            
                        
        } 
        catch (Exception e)
        {
            msg += " Servlet error: " + e.getMessage() + "<br>";
        }
        
        //student object s is build
            
        if(!msg.isEmpty()) //if error
        {
            URL="/Students.jsp"; //return home
            request.setAttribute("msg", msg); //sends the error to home page
        }
        else
        {
            ServletContext context = getServletContext();
            String txtpath = context.getRealPath("/WEB-INF/Classlist.txt");
            String serpath = context.getRealPath("/WEB-INF/Classlist.ser");
            
            try
            {
                StudentIO.addStudent(s,txtpath);
                msg += StudentIO.addStudentSer(s,serpath);
                //request.setAttribute("msg", "Student Data Saved. <br>");
            }
            catch (IOException e)
            {
                msg = "Unable to Save Student. <br>";
                //request.setAttribute("msg", msg);
            }
            if(!msg.isEmpty())
            {
                request.setAttribute("msg",msg);
            }
            else
            {
                request.setAttribute("msg", "Student Data Saved. <br>");
            }
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
