<%-- 
    Document   : discount
    Created on : May 12, 2020, 8:34:42 AM
    Author     : ahmed
--%>

<%@page import="com.store.common.beans.DrugsBean"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


          <%@ include file="header.jsp" %>  
          <form action="DiscountOperationsController?page=discountdiscount&operation=discountdiscount" method="POST">
      
      <table border="1">
                       <tbody>
                     <tr>
                         
                         <td>FROM</td>
                         <td><input type="number" name="from" value="" /></td>
                         
                     </tr>
                     <tr>
                         
                         <td>TO</td>
                         <td><input type="number" name="to" value="" /></td>
                         
                     </tr>
                     <tr>
                         
                          
                         <td><input type="submit" name="search" value="search" /></td>
                         
                     </tr>
                 </tbody>
             </table>
             <table border="1" width="90%">
                  <%
                               if (session.getAttribute("salebill")==null)
                               {
                               }
                               if (session.getAttribute("salebill")!=null)
                               {
                                      ArrayList <DrugsBean> al =( ArrayList <DrugsBean> )  session.getAttribute("salebill");
                                     if (al.size()==0)
                                     {
                                         out.print("no results");  
                                     }
                                     else
                                     {
                                        out.println("<thead> <tr>  <th>Name</th> <th>Type</th> <th>Price</th> <th>Discount</th> </tr>   </thead>  <tbody>");
                                    
                                    for (DrugsBean sb : al) 
                                    {
                                                out.print(" <tr> " );
                                                out.print("  <td>"+ sb.getName() +"</td>" );
                                                out.print(" <td>"+sb.getType()+"</td> ") ;
                                                out.print("  <td>"+sb.getSellingPrice()+"</td>  ");
                                                out.print("  <td>"+sb.getDiscount()+"</td>  ");
                                              
                                               
                                                out.print(" </tr>   ");
                                                                          
                                         
                                     }
                                      out.println(" </tbody>");
                                   
                                     }
                                     
                             }  
                               session.removeAttribute("salebill");
                             %>   
             </table>


      </form>
    </body>
</html>
