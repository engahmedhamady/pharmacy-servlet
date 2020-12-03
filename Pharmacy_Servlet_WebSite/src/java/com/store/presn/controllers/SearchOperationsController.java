/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.DrugsBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class SearchOperationsController extends HttpServlet {

  
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
        if (operation.equals("searchall")) {
            List<DrugsBean> selectAll = getWay.listAllSearch();
            session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("searchname")) {
            try {
                String name = request.getParameter("name");
                 List<DrugsBean> selectAll = getWay.listByNamefounded(name);
                   session.setAttribute("salebill", selectAll);
                if (selectAll.size() > 0) {

                    response.sendRedirect("MenuController?page=" + page);
                } else {
                    session.setAttribute("salebill", "not");
                    response.sendRedirect("MenuController?page=" + page);

                }
            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
            }

        }  else if (operation.equals("searchprice")) {
            try {
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));

                 List<DrugsBean> selectAll = getWay.listByPricefounded(from, to);
                  session.setAttribute("salebill", selectAll);
                if (selectAll.size() > 0) {

                    response.sendRedirect("MenuController?page=" + page);
                } else {
                    session.setAttribute("salebill", "not");
                    response.sendRedirect("MenuController?page=" + page);

                }
            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
            }
        } else if (operation.equals("searchtype")) {
            try {
                String name = request.getParameter("selected");
                System.out.println(name);
                List<DrugsBean> selectAll = getWay.listByTypefounded(name);
                  session.setAttribute("salebill", selectAll);
                if (selectAll.size() > 0) {

                    response.sendRedirect("MenuController?page=" + page);
                } else {
                    session.setAttribute("salebill", "not");
                    response.sendRedirect("MenuController?page=" + page);

                }
            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
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
