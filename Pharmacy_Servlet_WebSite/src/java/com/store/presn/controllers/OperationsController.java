/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Screens;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OperationsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");
        String operation = request.getParameter("operation");

        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        StoreGetWay getWay = new StoreGetWay();

        if (page == null || page.equals("") || page.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

        if (operation == null || operation.equals("") || operation.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        if (operation.equals("login")) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            AdminBean adminBean = new AdminBean();
            adminBean.setName(name);
            adminBean.setPassword(password);
            boolean admin = getWay.login(adminBean);
            if (!admin) {
                session.setAttribute("bean", null);
                adminBean.setIsLegalLogin("0");
            } else {
                adminBean.setIsLegalLogin("1");
               // adminBean.setScreenses(getWay.find(adminBean).getScreenses());
                session.setAttribute("bean", adminBean);
                Set screenses = getWay.find(adminBean).getScreenses();
                Iterator iterator = screenses.iterator();
                Set set = new HashSet();
                while (iterator.hasNext()) {
                   String next = ((Screens) iterator.next()).getPage();
                    set.add(next);
                    
                }
                 session.setAttribute("screens", set);
            }
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
