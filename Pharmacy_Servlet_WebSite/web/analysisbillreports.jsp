<%-- 
    Document   : analysisbillreports
    Created on : May 12, 2020, 8:36:10 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="OperationsController?page=analysisbillreports&operation=purchasebillcode" method="POST">


    <table  width="90%">

        <tbody>
            <tr>
                <td align="center">From</td>
                <td> <input type="date" id="birthday" name="fromdate"></td>

            </tr>
            <tr>

                <td align="center"> To</td>
                <td> <input type="date" id="birthday" name="todate"></td>    
            </tr>
            <%             if (session.getAttribute("analysis") == null) {%>
            <tr>
                <td align="center">Payment</td>
                <td><td> </td>
            </tr>
            <tr>
                <td align="center">Income</td>
                <td> </td>
            </tr>
            <tr>
                <td align="center">Profit</td>
                <td> </td>          
            </tr>
            <%
            } else if (session.getAttribute("analysis") != null) {
                if ((session.getAttribute("analysis").equals("error"))) {
            %>
            <tr>
                <td align="center">Payment</td>
                <td><td> </td>
            </tr>
            <tr>
                <td align="center">Income</td>
                <td> </td>
            </tr>
            <tr>
                <td align="center">Profit</td>
                <td> </td>          
            </tr>
            <tr>
        <h4>Enter Right Date</h4>           
        </tr>
        <%
        } else {
        %>
        <tr>
            <td align="center">Payment</td>
            <td> <%= (int) session.getAttribute("payment")%></td>      
        </tr>
        <tr>    
            <td align="center">Income</td>
            <td> <%= (int) session.getAttribute("income")%> </td>
        </tr>
        <tr>
            <td align="center">Profit</td>
            <td> <%= (int) session.getAttribute("profit")%> </td>
            <td salalaaalal</td>
        </tr>  
        <%
                }
            }
            session.removeAttribute("analysis");
            session.removeAttribute("profit");
            session.removeAttribute("income");
            session.removeAttribute("payment");
        %>


        <tr>  
            <td align="center"><input type="submit" name="OK" value="OK" /></td>  
        </tr>
        </tbody>
    </table>

</form>

</body>
</html>
