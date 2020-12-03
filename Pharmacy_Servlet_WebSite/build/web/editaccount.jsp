<%-- 
    Document   : editaccount
    Created on : May 12, 2020, 8:40:58 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
        <div class="site-block-cover-content text-center">
               <form action="SettingOperationsController?page=editaccount&operation=editaccount" method="POST">
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
                        <td>password</td>
                        <td> <input type="password" name="newPassword" value="" /></td>
                    </tr>
                    <tr>

                        <td colspan="2"  align=" center"> <input type="submit" value="Change" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
             
            </div>
           <%
                        if( session.getAttribute("edited")==null) 
                        {
                        
                        }
                        else
                        {
                               if ((int)session.getAttribute("edited")==0)
                               {
                                       out.print("<h1>sorry this username not valid </h1>");
                               } 
                               if ((int)session.getAttribute("edited")==1)
                               {
                                        out.print("<h1> password is updated</h1>");
                               }
                                session.removeAttribute("edited");
                        }

                    %>
               
               
    </body>
</html>
