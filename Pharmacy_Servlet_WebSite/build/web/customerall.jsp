<%-- 
    Document   : customers
    Created on : May 12, 2020, 8:34:00 AM
    Author     : ahmed
--%>

<%@page import="com.store.common.beans.CustomerBean"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="CustomerOperationsController?page=customerall&operation=customerall" method="POST">
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
                ArrayList<CustomerBean> al = (ArrayList<CustomerBean>) session.getAttribute("salebills");
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
            session.removeAttribute("salebills");
        %>    
    </table>


</form>
</body>
</html>
