<%-- 
    Document   : salebillreports
    Created on : May 12, 2020, 8:35:23 AM
    Author     : ahmed
--%>


<%@page import="com.store.common.beans.SalesBillsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="ReportsOperationsController?page=salebillreportstotal&operation=saletotal" method="POST">
    <table border="1">
        <tbody>
            <tr>
            <tr>

        <input type="submit"  value="Search" />   
        <td>From</td>
        <td><input type="text"name="fromSearch" value="" /></td>
        <td>To</td>
        <td><input type="text" name="toSearch"value="" /></td>


        </tr>



        </tbody>
    </table>
    <table border="1" width="90%">
        <%                       if (session.getAttribute("salebill") == null) {
            } else if (session.getAttribute("salebill") != null) {
                if ((session.getAttribute("salebill").equals("error"))) {
                    out.print("Enter Right Number");
                } else if ((session.getAttribute("salebill").equals("not"))) {
                    out.print("Not found");
                } else {
                    ArrayList<SalesBillsBean> al = (ArrayList) session.getAttribute("salebill");
                    if (al.size() == 0) {
                        out.print("no results");
                    } else {
                        out.println("<thead> <tr>  <th>Bill Code</th> <th>Total</th> <th>Profit</th> <th>Date</th></tr>   </thead>  <tbody>");

                        for (SalesBillsBean sb : al) {
                            out.print(" <tr> ");
                            out.print("  <td>" + sb.getBillcode() + "</td>");
                            out.print(" <td>" + sb.getTotalnet() + "</td> ");
                            out.print("  <td>" + sb.getTotalprofits() + "</td>  ");
                            out.print("  <td>" + sb.getBilldate() + "</td>  ");
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
