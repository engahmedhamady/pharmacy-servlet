<%-- 
    Document   : founded
    Created on : May 12, 2020, 8:33:35 AM
    Author     : ahmed
--%>

<%@page import="com.store.common.beans.DrugsBean"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="PurchasesOperationsController?page=foundedall&operation=foundall" method="POST">

    <table border="1">
        <tbody>
            <tr>
                <td>
                    <input type="submit"  value="Search" />   
                </td>

            </tr>
        </tbody>
    </table>
    <table border="1" width="90%">
        <table border="1" width="90%">

            <%                      if (session.getAttribute("salebills") == null) {
                }
                if (session.getAttribute("salebills") != null) {
                    ArrayList<DrugsBean> al = (ArrayList<DrugsBean>) session.getAttribute("salebills");
                    if (al.size() == 0) {
                        out.print("no results");
                    } else {
                        out.println("<thead> <tr>  <th>Name</th> <th>Type</th> <th>Price</th> <th>Discount</th><th>Quantity</th> <th>Company</th></tr>   </thead>  <tbody>");

                        for (DrugsBean sb : al) {
                            out.print(" <tr> ");
                            out.print("  <td>" + sb.getName() + "</td>");
                            out.print(" <td>" + sb.getType() + "</td> ");
                            out.print("  <td>" + sb.getSellingPrice() + "</td>  ");
                            out.print("  <td>" + sb.getDiscount() + "</td>  ");
                            out.print("  <td>" + sb.getQuantity() + "</td>  ");
                         
                            out.print("  <td>" + sb.getCompany() + "</td>  ");
                            out.print(" </tr>   ");

                        }
                        out.println(" </tbody>");

                    }

                }
                session.removeAttribute("salebills");
            %>    
        </table>


</form>
</body>
</html>
