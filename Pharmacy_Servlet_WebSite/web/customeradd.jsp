<%-- 
    Document   : customers
    Created on : May 12, 2020, 8:34:00 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
     <div class="site-block-cover-content text-center">
               <form action="CustomerOperationsController?page=customeradd&operation=customeradd" method="POST">
                              <table border="0" width="40%" cellspacing="5 " >

                                        <tbody>
                                                       <tr>
                                                              <td> NAME </td>
                                                              <td><input type="text" name="name" value=""  /> </td>
                                                       </tr>
                                                       <tr>
                                                              <td>EMAIL</td>
                                                              <td> <input type="text" name="email" value="" /></td>
                                                       </tr>
                                                       <tr>
                                                              <td>PHONE</td>
                                                              <td> <input type="text" name="phone" value="" /></td>
                                                       </tr>
                                                       
                                                       <tr>

                                                              <td colspan="2"  align=" center"> <input type="submit" value="Add" /></td>
                                                       </tr>
                                        </tbody>
                             </table>

                </form>
               <%
                        if( session.getAttribute("founded")==null) 
                        {
                        
                        }
                        else
                        {
                               if ((int)session.getAttribute("founded")==0)
                               {
                                       out.print("<h1>sorry this username not invalid try with another name</h1>");
                               } 
                               if ((int)session.getAttribute("founded")==1)
                               {
                                        out.print("<h1> username is created</h1>");
                               }
                                session.removeAttribute("founded");
                        }

                
               
               %>
             
            </div>
    </body>
</html>
