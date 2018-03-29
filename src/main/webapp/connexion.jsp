<%-- 
    Document   : connexion
    Created on : 29 mars 2018, 14:10:46
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="utf-8" />
            <title>Connexion</title>
        </head>
        <body>   
            <h1>Merci de vous connecter</h1>
            <%     
            String mail = "";
            String password = "";
            if(request.getAttribute("mail") != null) { 
                mail = (String) request.getAttribute("mail");
            }

            if(request.getAttribute("password") != null) { 
                password = (String) request.getAttribute("password");
            }
            %>
            <form method="post" action="AdminCheck">
                Email: <input type="text" name="mail" value="<%=mail%>"><br>
                Mot de passe: <input type="text" name="password" value="<%=password%>"><br>
                <input type="submit" value="Connexion">
            </form>
            %> 
        </body>
    </html>
</f:view>
