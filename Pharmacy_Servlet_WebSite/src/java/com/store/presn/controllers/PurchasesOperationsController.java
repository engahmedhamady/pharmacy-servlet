/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.CustomerBean;
import com.store.common.beans.DrugsBean;
import com.store.common.beans.LostDrugsBean;
import com.store.common.beans.PurchasesBillsBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchasesOperationsController extends HttpServlet {

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
        if (operation.equals("save")) {
            // get parameter
            String name= request.getParameter("name");
            String type= request.getParameter("type");
            String company= request.getParameter("company");
            String barcode= request.getParameter("barcode");
            String quantity = request.getParameter("quantity");
             String sell= request.getParameter("sell");
              String discount = request.getParameter("discount");
               String purchase = request.getParameter("purchase");
            // set bean 
           java.util.Date date = new java.util.Date(new java.util.Date().getTime());
             PurchasesBillsBean bean = new PurchasesBillsBean();
            bean.setBarCode(barcode);
            bean.setBillCode(getWay.createBill());
            bean.setCompany(company);
            bean.setDateBill(date);
            bean.setDiscount(Integer.parseInt(discount));
            bean.setDrugName(name);
            bean.setDrugType(type);
            bean.setPurchasePrice(Integer.parseInt(purchase));
            bean.setQuantityDrug(Integer.parseInt(quantity));
            bean.setSellPrice(Integer.parseInt(sell));
            bean.setTotal(Integer.parseInt(quantity)*Integer.parseInt(purchase));
            PurchasesBillsBean selectAll = getWay.saveBill(bean);
            session.setAttribute("salebills", selectAll);
            if (selectAll != null) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("foundall")) {

            List<DrugsBean> selectAll = getWay.listAllFounded();
            session.setAttribute("salebills", selectAll);
            if (selectAll.size() > 0) {
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
            }
        } else if (operation.equals("foundname")) {

            String name = request.getParameter("name");
            List<DrugsBean> selectAll = getWay.listByNamefounded(name);
            session.setAttribute("salebill", selectAll);
            if (selectAll.size() > 0) {

                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }

        } else if (operation.equals("foundtype")) {
            try {
                String type = request.getParameter("selected");

                List<DrugsBean> selectAll = getWay.listByTypefounded(type);
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
        } else if (operation.equals("foundquantity")) {
            try {
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));

                List<DrugsBean> selectAll = getWay.listByQuantityfounded(from, to);
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
        } else if (operation.equals("foundprice")) {
            try {
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));

                List< DrugsBean> selectAll = getWay.listByPricefounded(from, to);
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
        } else if (operation.equals("foundcompany")) {

            try {
                String name = request.getParameter("name");
                List<DrugsBean> selectAll = getWay.listByCompanyfounded(name);
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

        } else if (operation.equals("requestall")) {

            List< LostDrugsBean> selectAll = getWay.listAllRequested();

            if (selectAll.size() > 0) {
                session.setAttribute("salebills", selectAll);
                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }
        } else if (operation.equals("requestname")) {

            String name = request.getParameter("name");

            List< LostDrugsBean> selectAll = getWay.listByNameRequested(name);

            if (selectAll.size() > 0) {
                session.setAttribute("salebill", selectAll);
                response.sendRedirect("MenuController?page=" + page);
            } else {
                session.setAttribute("salebill", "not");
                response.sendRedirect("MenuController?page=" + page);

            }

        } else if (operation.equals("requestadd")) {
            String name = request.getParameter("name");
            String type = request.getParameter("selected");
            String quantity = request.getParameter("quantity");
            LostDrugsBean bean = new LostDrugsBean();
            bean.setDrugname(name);
            bean.setDrugtype(type);
            bean.setQuantitydrug(Integer.parseInt(quantity));
            LostDrugsBean addRequested = getWay.addRequested(bean);
            if (addRequested != null) {

                session.setAttribute("founded", 1);
                response.sendRedirect("MenuController?page=" + page);
            } else if (addRequested == null) {
                session.setAttribute("founded", 0);
                response.sendRedirect("MenuController?page=" + page);
            } else {
                response.sendRedirect("MenuController?page=errorPage");
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
