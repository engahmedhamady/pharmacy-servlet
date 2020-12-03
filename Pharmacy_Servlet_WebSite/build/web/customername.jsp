<%-- 
    Document   : customers
    Created on : May 12, 2020, 8:34:00 AM
    Author     : ahmed
--%>


<%@page import="com.store.common.beans.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="CustomerOperationsController?page=customername&operation=customername" method="POST">
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
                    ArrayList<CustomerBean> al = (ArrayList) session.getAttribute("salebill");
                    if (al.size() == 0) {
                        out.print("no results");
                    } else {
                        out.println("<thead> <tr>  <th>Name</th> <th>Email</th> <th>Phone</th> </tr>   </thead>  <tbody>");

                        for (CustomerBean sb : al) {
                            out.print(" <tr> ");
                            out.print("  <td>" + sb.getName() + "</td>");
                            out.print(" <td>" + sb.getEmail() + "</td> ");
                            out.print("  <td>" + sb.getPhone() + "</td>  ");
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
