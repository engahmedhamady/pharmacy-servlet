<%-- 
    Document   : index
    Created on : May 12, 2020, 8:02:09 AM
    Author     : ahmed
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" import="com.store.presn.constansApp.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%  request.setAttribute(Constants.TITLE_ATTRIBUTE, "login page");%>
        <title><%=   request.getAttribute(Constants.TITLE_ATTRIBUTE)  %></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">


        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>

    <body>

        <div class="site-navbar py-2">

            <div class="search-wrap">
                <div class="container">
                    <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
                    <form action="#" method="post">
                        <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
                    </form>
                </div>
            </div>

            <div class="container" >
                <div class="d-flex align-items-center justify-content-between">
                    <div class="logo">
                        <div class="site-logo">
                            <a href="index.jsp" class="js-logo-clone">Pharma</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
   
    <div class="site-blocks-cover" style="background-image: url('images/hero_1.jpg');">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 mx-auto order-lg-2 align-self-center">
            <div class="site-block-cover-content text-center">
               <form action="OperationsController?page=home&operation=login" method="POST">
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

                        <td colspan="2"  align=" center"> <input type="submit" value="login" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
             
            </div>
          </div>
        </div>
      </div>
    </div>
      


    </body>
</html>
