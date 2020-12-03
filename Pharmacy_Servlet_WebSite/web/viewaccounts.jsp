<%-- 
    Document   : viewaccounts
    Created on : May 12, 2020, 8:41:18 AM
    Author     : ahmed
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form method="POST" action="SettingOperationsController?page=viewaccounts&operation=viewaccount">
    <input type="submit" value="View" />

    <table border="1" width="90%">



        <%                         if (session.getAttribute("accounts") != null) {
                ArrayList<AdminBean> al = (ArrayList) session.getAttribute("accounts");
                if (al.size() == 0) {
                    out.print("no results");
                } else {
                    out.println("<thead> <tr>  <th>User Name</th>  </tr>   </thead>  <tbody>");

                    for (AdminBean admins : al) {
                        out.println(" <tr> <td>" + admins.getName() + " </td></tr>");
                    }
                    out.println(" </tbody>");
                    session.removeAttribute("accounts");
                }
            }
        %>        


    </table>
</form>
</body>
</html>
