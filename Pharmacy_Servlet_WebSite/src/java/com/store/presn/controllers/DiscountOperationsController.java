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

public class DiscountOperationsController extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");
        String operation = request.getParameter("operation");
   StoreGetWay getWay =   new StoreGetWay();     RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();

        if (page == null || page.equals("") || page.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

        if (operation == null || operation.equals("") || operation.trim().equals("")) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        if (operation.equals("discountall")) {

            List<DrugsBean> selectAll = getWay.listAllDiscount();
            session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("discountname")) {
            try {
                String name = request.getParameter("name");
                List< DrugsBean> selectAll = getWay.findByNameDiscount(name);
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

        } else if (operation.equals("discountprice")) {
            try {
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));

                List< DrugsBean> selectAll = getWay.findByPriceDiscount(from, to);
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
        } else if (operation.equals("discounttype")) {
            try {
                String name = request.getParameter("selected");
                System.out.println(name);
                List< DrugsBean> selectAll =  getWay.findByTypeDiscount(name);
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

        } else if (operation.equals("discountdiscount")) {
            try {
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));

                List< DrugsBean> selectAll = getWay.findByDiscount(from, to);
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
