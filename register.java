/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell-2
 */
public class register extends HttpServlet {

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
       
        String a1,a2,a3,a4,a5;
        PrintWriter p=response.getWriter();
        a1=request.getParameter("fn");
        a2=request.getParameter("ln");
        a3=request.getParameter("em");
        a4=request.getParameter("un");
        a5=request.getParameter("up");
        List li=new LinkedList();
        if(a1.length()==0){
        li.add("Fill First Name");
                }
        if(a2.length()==0){
        li.add("Fill Last Name");}
        if(a3.length()==0){
        li.add("Fill email");}
        if(a4.length()==0){
        li.add("Fill User Name");}
        if(a5.length()==0){
            li.add("Fill Password");
        }
        if(!li.isEmpty())
        {
            Iterator it=li.iterator();
            while(it.hasNext())
            {
                p.print("<font color='red'>"+it.next().toString()+"<br>");
            }
            
            
        }
        else
        {
        HttpSession hs=request.getSession();
        hs.setAttribute("fname", a1);
        hs.setAttribute("lname", a2);
        hs.setAttribute("email", a3);
        hs.setAttribute("uname", a4);
        hs.setAttribute("upass", a5);
        if(hs!=null)
        {
            RequestDispatcher rd=request.getRequestDispatcher("/login.html");
            rd.include(request, response);
            p.print("After Registration kindly login"+new Date(hs.getCreationTime()));
            
        }
        }
        
        
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
