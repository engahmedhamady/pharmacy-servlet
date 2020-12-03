/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.CustomerBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerOperationsController extends HttpServlet {

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
        if (operation.equals("customerall")) {

            List< CustomerBean> selectAll = getWay.listAllCustomer();
            session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {

                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }

        } else if (operation.equals("customername")) {

            String name = request.getParameter("name");

            List< CustomerBean> selectAll = getWay.listByNameCustomer(name);
            session.setAttribute("salebill", selectAll);
            if (selectAll.size() > 0) {

                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }

        } else if (operation.equals("customeradd")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            CustomerBean bean = new CustomerBean();
            bean.setEmail(email);
            bean.setName(name);
            bean.setPhone(phone);
            CustomerBean addCustomer = getWay.addCustomer(bean);
            if (addCustomer == null) {
                session.setAttribute("founded", 0);
                response.sendRedirect("MenuController?page=" + page);
            } else if (addCustomer != null) {

                session.setAttribute("founded", 1);
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }

        }

    }


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
