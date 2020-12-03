<%-- 
    Document   : requested
    Created on : May 12, 2020, 8:33:47 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="PurchasesOperationsController?page=requestadd&operation=requestadd" method="POST">

    <table border="0">
        <tbody>

            <tr>
                <td> name </td>
                <td><input type="text" name="name" value=""  /> </td>
            </tr>
            <tr>
                <td>quantity</td>
                <td> <input type="number" name="quantity" value="" /></td>
            </tr>

            <tr>
                <td> type</td>
                 <td>
                     <select name = "selected">

                        <option value = "ointment">ointment</option>
                        <option value = "injection">injection</option>
                        <option value = "capsule">capsule</option>
                    </select>
                 </td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>

            </tr>
        </tbody>
</form>
 <%                   if (session.getAttribute("founded") == null) {

        } else {
            if ((int) session.getAttribute("founded") == 0) {
                out.print("<h1>failed operation try again</h1>");
            }
            if ((int) session.getAttribute("founded") == 1) {
                out.print("<h1> drug addded</h1>");
            }
            session.removeAttribute("founded");
        }


    %>

</body>
</html>
