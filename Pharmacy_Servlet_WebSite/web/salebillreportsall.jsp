
<%@page import="com.store.common.beans.SalesBillsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="ReportsOperationsController?page=salebillreportsall&operation=saleall" method="POST">
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
                ArrayList<SalesBillsBean> al = (ArrayList) session.getAttribute("salebills");
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
            session.removeAttribute("salebills");
        %>    
    </table>


</form>
</body>
</html>
