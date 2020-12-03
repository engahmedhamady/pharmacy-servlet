<%-- 
    Document   : purchasebillreports
    Created on : May 12, 2020, 8:35:44 AM
    Author     : ahmed
--%>


<%@page import="com.store.common.beans.PurchasesBillsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="ReportsOperationsController?page=purchasebillreportsbillcode&operation=purchasebillcode" method="POST">

    <table border="1">
        <tbody>
            <tr>
        <input type="submit"  value="Search" />   
        <input type="text" name="billCode" value="" />   
        </tr>
        </tbody>
    </table>
    <table border="1" width="90%">

        <%                    if (session.getAttribute("salebill") == null) {
            } else if (session.getAttribute("salebill") != null) {
                if ((session.getAttribute("salebill").equals("error"))) {
                    out.print("Enter Right Number");
                } else if ((session.getAttribute("salebill").equals("not"))) {
                    out.print("Not found");
                } else {
                    ArrayList<PurchasesBillsBean> al = (ArrayList) session.getAttribute("salebill");
                    if (al.size() == 0) {
                        out.print("no results");
                    } else {
                        out.println("<thead> <tr>  <th>Bill Code</th> <th>Total</th> <th>Date</th></tr>   </thead>  <tbody>");

                        for (PurchasesBillsBean sb : al) {
                            out.print(" <tr> ");
                            out.print("  <td>" + sb.getBillCode() + "</td>");
                            out.print(" <td>" + sb.getTotal() + "</td> ");

                            out.print("  <td>" + sb.getDateBill() + "</td>  ");
                            out.print(" </tr>   ");

                        }
                        out.println(" </tbody>");

                    }

                }

            }
            session.removeAttribute("salebill");
        %>
    </table>


</form>
</body>
</html>
