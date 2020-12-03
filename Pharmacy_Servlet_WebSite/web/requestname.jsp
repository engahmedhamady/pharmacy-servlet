<%-- 
    Document   : requested
    Created on : May 12, 2020, 8:33:47 AM
    Author     : ahmed
--%>

<%@page import="com.store.common.beans.LostDrugsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
          <form action="PurchasesOperationsController?page=requestname&operation=requestname" method="POST">
    <table border="1">
        <tbody>
            <tr>
        <input type="submit"  value="Search" />   
        <input type="text" name="name" value="" />   
        </tr>
        </tbody>
    </table>
    <table border="1" width="90%">

        <%                     if (session.getAttribute("salebill") == null) {
            } else if (session.getAttribute("salebill") != null) {
                if ((session.getAttribute("salebill").equals("error"))) {
                    out.print("Enter Right Name");
                } else if ((session.getAttribute("salebill").equals("not"))) {
                    out.print("Not found");
                } else {
                    ArrayList<LostDrugsBean> al = (ArrayList) session.getAttribute("salebill");
                    if (al.size() == 0) {
                        out.print("no results");
                    } else {
                        out.println("<thead> <tr>  <th>Name</th> <th>Type</th> <th>Quantity</tr>   </thead>  <tbody>");

                        for (LostDrugsBean sb : al) {
                            out.print(" <tr> ");
                            out.print("  <td>" + sb.getDrugname() + "</td>");
                            out.print(" <td>" + sb.getDrugtype() + "</td> ");
                            out.print("  <td>" + sb.getQuantitydrug() + "</td>  ");
                           
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
