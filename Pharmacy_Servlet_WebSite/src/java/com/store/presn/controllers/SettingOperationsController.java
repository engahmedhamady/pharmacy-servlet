/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SettingOperationsController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");
        String operation = request.getParameter("operation");

        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
           StoreGetWay getWay =   new StoreGetWay();
        if (page == null || page.equals("") || page.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

        if (operation == null || operation.equals("") || operation.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        if (operation.equals("viewaccount")) {

            List<AdminBean> selectAll = getWay.listAll();
            session.setAttribute("accounts", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("addaccount")) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            AdminBean admin = new AdminBean();
            admin.setName(name);
            admin.setPassword(password);

            boolean login = getWay.login(admin);
            if (login) {
                session.setAttribute("founded", 0);
                response.sendRedirect("MenuController?page=" + page);

            } else if (!login) {
                getWay.addAccount(admin);
                session.setAttribute("founded", 1);
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("editaccount")) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            AdminBean admin = new AdminBean();
            admin.setName(name);
            admin.setPassword(password);

            boolean login = getWay.login(admin);
            if (!login) {
                session.setAttribute("edited", 0);
                response.sendRedirect("MenuController?page=" + page);
            } else if (login) {
                admin.setPassword(request.getParameter("newPassword"));
                getWay.updatePassword(admin);
                 session.setAttribute("edited",1);
                response.sendRedirect("MenuController?page=" + page);

            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("deleteaccount")) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            AdminBean admin = new AdminBean();
            admin.setName(name);
            admin.setPassword(password);
            boolean login = getWay.login(admin);
            if (!login) {
                session.setAttribute("deleted", 0);
                response.sendRedirect("MenuController?page=" + page);
            } else if (login) {

                getWay.deleteAccount(admin);
                 session.setAttribute("deleted", 1);
                response.sendRedirect("MenuController?page=" + page);

            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("priviliges")) {

          
            response.sendRedirect("MenuController?page=" + page);
                
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
