/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.PurchasesBillsBean;
import com.store.common.beans.SalesBillsBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReportsOperationsController extends HttpServlet {

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
        } else if (operation.equals("saleall")) {
            List<SalesBillsBean> selectAll = getWay.listAllSales();
            session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("salebillcode")) {

            String billCode = request.getParameter("billCode");
            List<SalesBillsBean> selectAll = getWay.findByCodeSales(Integer.parseInt(billCode));
            session.setAttribute("salebill", selectAll);
            if (selectAll.size() > 0) {

                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }

        } else if (operation.equals("saletotal")) {

            try {
                String from = request.getParameter("fromSearch");
                String to = request.getParameter("toSearch");
                if (Integer.parseInt(from) < Integer.parseInt(to)) {
                    List<SalesBillsBean> selectAll = getWay.findByTotalSales(Integer.parseInt(from), Integer.parseInt(to));
                    session.setAttribute("salebill", selectAll);
                    if (selectAll.size() > 0) {
                        response.sendRedirect("MenuController?page=" + page);
                    } else {
                        session.setAttribute("salebill", "not");
                        response.sendRedirect("MenuController?page=" + page);
                    }
                } else {

                    session.setAttribute("salebill", "error");
                    response.sendRedirect("MenuController?page=" + page);
                }

            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
            }

        }  else if (operation.equals("saleprofit")) {

            try {
                String from = request.getParameter("fromSearch");
                String to = request.getParameter("toSearch");
                if (Integer.parseInt(from) < Integer.parseInt(to)) {
                    List<SalesBillsBean> selectAll = getWay.findByProfitSales(Integer.parseInt(from), Integer.parseInt(to));
                     session.setAttribute("salebill", selectAll);
                    if (selectAll.size() > 0) {
                        response.sendRedirect("MenuController?page=" + page);
                    } else {
                        session.setAttribute("salebill", "not");
                        response.sendRedirect("MenuController?page=" + page);
                    }
                } else {

                    session.setAttribute("salebill", "error");
                    response.sendRedirect("MenuController?page=" + page);
                }

            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
            }

        } else if (operation.equals("purchaseall")) {

            List<PurchasesBillsBean> selectAll = getWay.listAllPurchases();
                     session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("purchasebillcode")) {
            try {
                String billCode = request.getParameter("billCode");
                List<PurchasesBillsBean> selectAll = getWay.findByCodePurchases(Integer.parseInt(billCode));
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

        } else if (operation.equals("purchasetotal")) {

            try {
                String from = request.getParameter("fromSearch");
                String to = request.getParameter("toSearch");
                if (Integer.parseInt(from) < Integer.parseInt(to)) {
                    List<PurchasesBillsBean> selectAll = getWay.findByTotalPurchases
      (Integer.parseInt(from), Integer.parseInt(to));
                            session.setAttribute("salebill", selectAll);
                    if (selectAll.size() > 0) {
                        response.sendRedirect("MenuController?page=" + page);
                    } else {
                        session.setAttribute("salebill", "not");
                        response.sendRedirect("MenuController?page=" + page);
                    }
                } else {

                    session.setAttribute("salebill", "error");
                    response.sendRedirect("MenuController?page=" + page);
                }

            } catch (Exception e) {
                session.setAttribute("salebill", "error");
                response.sendRedirect("MenuController?page=" + page);
            }

        }              
        else if (operation.equals("analysis")) {

            try {
                String from = request.getParameter("fromdate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(from);
                String to = request.getParameter("todate");
                Date endDate = sdf.parse(to);
                int totalProfit = 0;
                int totalPayment = 0;
                int totalIncome = 0;
                if (startDate.compareTo(endDate) < 0) {
                    session.setAttribute("analysis", "ok");
                    totalPayment = getWay.payment(endDate, endDate);
                   
                        totalProfit = getWay.profits(endDate, endDate);
                           totalIncome = getWay.incom(endDate, endDate);
                    
                    session.setAttribute("payment", totalPayment);
                    session.setAttribute("income", totalIncome);
                    session.setAttribute("profit", totalProfit);
                    response.sendRedirect("MenuController?page=" + page);
                } else {
                    session.setAttribute("analysis", "error");
                    response.sendRedirect("MenuController?page=" + page);
                }
            } catch (Exception e) {
                session.setAttribute("analysis", "error");
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
