<%-- 
    Document   : addaccount
    Created on : May 12, 2020, 8:40:26 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<div class="site-block-cover-content text-center">
    <form action="SettingOperationsController?page=addaccount&operation=addaccount" method="POST">
        <table border="0" width="40%" cellspacing="5 " >

            <tbody>
                <tr>
                    <td> user name </td>
                    <td><input type="text" name="name" value=""  /> </td>
                </tr>
                <tr>
                    <td>password</td>
                    <td> <input type="password" name="password" value="" /></td>
                </tr>
                <tr>

                    <td colspan="2"  align=" center"> <input type="submit" value="Add" /></td>
                </tr>
            </tbody>
        </table>

    </form>
    <%                   if (session.getAttribute("founded") == null) {

        } else {
            if ((int) session.getAttribute("founded") == 0) {
                out.print("<h1>sorry this username not invalid try with another name</h1>");
            }
            if ((int) session.getAttribute("founded") == 1) {
                out.print("<h1> username is created</h1>");
            }
            session.removeAttribute("founded");
        }


    %>

</div>
</body>
</html>
