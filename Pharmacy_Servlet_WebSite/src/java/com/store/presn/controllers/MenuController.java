/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.presn.constansApp.Constants;
import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import java.io.IOException;
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
public class MenuController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        HttpSession session = request.getSession(true);
        RequestDispatcher requestDispatcher = null;
//ApplicationContext context = new ClassPathXmlApplicationContext("/com/store/bll/config/bll-spring-context.xml");
     StoreGetWay getWay =   new StoreGetWay();


        if (page == null || page.equals("") || page.trim().equals("")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "login page");
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }

        if (page.equals("home")) {
            AdminBean admin = (AdminBean) session.getAttribute("bean");
            if (admin == null || !admin.getIsLegalLogin().equals("1")) {

                request.setAttribute(Constants.TITLE_ATTRIBUTE, "login page");
                page = "login";
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                //  requestDispatcher= request.getRequestDispatcher(page+".jsp");

            } else {
                request.setAttribute(Constants.TITLE_ATTRIBUTE, "home page");
                requestDispatcher = request.getRequestDispatcher(page + ".jsp");
            }
        } else if (page.equals("newsales")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "new sales page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("deliverylist")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "delivery list page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("newpurchase")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "new purchase page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedname")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedtype")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedquantity")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedexpiry")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedprice")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("foundedcompany")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "founded page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("requestall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "requested page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("requestname")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "requested page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("requestadd")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "requested page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("customerall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "customers page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("customername")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "customers page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("customeradd")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "customers page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("searchall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("searchname")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("searchtype")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("searchprice")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("searchexpiry")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("discountall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "search page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("discountdiscount")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "discount page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("discountname")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "discount page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("discountprice")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "discount page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("discounttype")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "discount page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("salebillreportsall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "sale bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("salebillreportsdate")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "sale bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("salebillreportsbillcode")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "sale bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("salebillreportstotal")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "sale bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("salebillreportsprofit")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "sale bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("purchasebillreportsall")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "purchase bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("purchasebillreportsdate")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "purchase bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("purchasebillreportstotal")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "purchase bill reports  page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("purchasebillreportsbillcode")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "purchase bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("analysisbillreports")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "analysis bill reports page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("addaccount")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "add account page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("deleteaccount")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "delete account page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("editaccount")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "edit account page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("viewaccounts")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "view accounts page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("priviliges")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "priviliges page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("about")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "about page");
            requestDispatcher = request.getRequestDispatcher(page + ".jsp");
        } else if (page.equals("logout")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "login page");
            ((AdminBean) session.getAttribute("log")).setIsLegalLogin("0");

            session.removeAttribute("log");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            session.invalidate();
            requestDispatcher = request.getRequestDispatcher("index.jsp");

        } else if (page.equals("errorPage")) {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "error Page");
            requestDispatcher = request.getRequestDispatcher("errorPage.html");
        } else {
            request.setAttribute(Constants.TITLE_ATTRIBUTE, "login page");
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }

        requestDispatcher.forward(request, response);

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
    }

}
