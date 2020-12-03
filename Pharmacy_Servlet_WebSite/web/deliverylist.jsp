<%-- 
    Document   : deliverylist
    Created on : May 12, 2020, 8:31:51 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
       
         <form>
             <table border="1">
                       <tbody>
                     <tr>
                         <td><input type="submit" value="Clear" /></td>
                         <td><input type="submit" value="Search" /></td>
                         <td><input type="text" name="usrName" value="" /></td>
                         <td>
                             <select name = "dropdown">
                                   <option value = "all" selected>ALL</option>
                                    <option value = "code">Bill Code</option>
                                  
                            </select></td>
                     </tr>
                 </tbody>
             </table>
             <table border="1" width="90%">
                 <thead>
                     <tr>
                         <th>Bill Code</th>
                     </tr>
                 </thead>
                 <tbody>
                 </tbody>
             </table>


      </form>
    </body>
</html>
