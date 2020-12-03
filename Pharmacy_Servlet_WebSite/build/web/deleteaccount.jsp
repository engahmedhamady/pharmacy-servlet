<%-- 
    Document   : deleteaccount
    Created on : May 12, 2020, 8:40:43 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
        <div class="site-block-cover-content text-center">
               <form action="SettingOperationsController?page=deleteaccount&operation=deleteaccount" method="POST">
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

                        <td colspan="2"  align=" center"> <input type="submit" value="Delete" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
             
            </div>
        <%
                        if( session.getAttribute("deleted")==null) 
                        {
                        
                        }
                        else
                        {
                               if ((int)session.getAttribute("deleted")==0)
                               {
                                       out.print("<h1>sorry this username not valid </h1>");
                               } 
                               if ((int)session.getAttribute("deleted")==1)
                               {
                                        out.print("<h1> account is deleted</h1>");
                               }
                                session.removeAttribute("deleted");
                        }

                    %>
    </body>
</html>
