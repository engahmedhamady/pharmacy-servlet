<%-- 
    Document   : newsales
    Created on : May 12, 2020, 8:31:24 AM
    Author     : ahmed
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  

<form method="POST" action="SalesOperationController?page=newsales&operation=save"  >
    <table border="1">
        <thead>
            <tr>
                <th>Seq</th>
                <th>NAME</th>
                <th>QUANTITY</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td><input type="text" name="drug1" value="" /></td>
                <td><input type="number" name="num1" value="" /></td>
            </tr>
            <tr>
                <td>2</td>
                <td><input type="text" name="drug2" value="" /></td>
                <td><input type="number" name="num2" value="" /></td>
            </tr>
            <tr>
                <td>3</td>
                <td><input type="text" name="drug3" value="" /></td>
                <td><input type="number" name="num3" value="" /></td>
            </tr>
            <tr>
                <td>4</td>
                <td><input type="text" name="drug4" value="" /></td>
                <td><input type="number" name="num4" value="" /></td>
            </tr>
            <tr>
                <td>5</td>
                <td><input type="text" name="drug5" value="" /></td>
                <td> <input type="number" name="num5" value="" /></td>
            </tr>
            <tr>
                 <th><a href="SalesOperationController?page=newsales&operation=delivery">Delivery</a></th>
                <th><a href="SalesOperationController?page=newsales&operation=cancel">Cancel</a></th>
             </tr>
            
        </tbody>
    </table>

</form>

<%      if (session.getAttribute("ok") != null) {
            if (session.getAttribute("ok").equals("1")) {
                  out.print("   <h1> ");
                  out.print(" bill added with code =" + session.getAttribute("code"));
                  out.print("  </h1>");
            } else if (session.getAttribute("ok").equals("0")) {
                  out.print("   <h1> ");
                  out.print("failed added try again");
                  out.print("  </h1>");
            }

      }
%>





</body>

</html>
