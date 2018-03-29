<%-- 
    Document   : pageadmin
    Created on : 29 mars 2018, 09:08:59
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Connexion Admin</title>
        </head>
        <body>
            <h1>Vous êtes connecté en tant qu'admin</h1>
            <%@page %>
            <%
            out.print("<br/>");
            out.print("Connecté");
            out.print("<br/>");   
            session.invalidate();
            %>
            <a href="index.html">Retour menu prinicpal</a>
        </body>
    </html>
</f:view>
