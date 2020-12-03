<%-- 
    Document   : requested
    Created on : May 12, 2020, 8:33:47 AM
    Author     : ahmed
--%>


<%@page import="java.util.List"%>
<%@page import="com.store.common.beans.LostDrugsBean"%>
<%@page import="com.store.common.beans.DrugsBean"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="PurchasesOperationsController?page=requestall&operation=requestall" method="POST">
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

        <%                      if (session.getAttribute("salebills") == null) {
            }
            if (session.getAttribute("salebills") != null) {
                List<LostDrugsBean> al = (List<LostDrugsBean>) session.getAttribute("salebills");
                if (al.size() == 0) {
                    out.print("no results");
                } else {
                    out.println("<thead> <tr>  <th>Name</th> <th>Type</th> <th>Quantity</th> </tr>   </thead>  <tbody>");

                    for (LostDrugsBean sb : al) {
                        out.print(" <tr> ");
                        out.print("  <td" + sb.getDrugname() + "</td>");
                       // out.print(" <td>" + sb.getDrugtype() + "</td> ");
                       // out.print("  <td>" + sb.getQuantitydrug() + "</td>"); 
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
