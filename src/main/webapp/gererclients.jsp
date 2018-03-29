<%-- 
    Document   : gererclients
    Created on : 29 mars 2018, 18:39:37
    Author     : RHAW
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Utilisateur"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <title>JSP Page</title>
        </head>
        <body>
            <%  
            ArrayList<Utilisateur> prospects = new ArrayList();
            ArrayList<Utilisateur> enattente = new ArrayList();
            ArrayList<Utilisateur> abonnes = new ArrayList();
            if(request.getAttribute("listeProspects") != null) { 
                prospects = (ArrayList<Utilisateur>) request.getAttribute("listeProspects");
            }
            if(request.getAttribute("listeEnAttente") != null) { 
                enattente = (ArrayList<Utilisateur>) request.getAttribute("listeEnAttente");
            }
            if(request.getAttribute("listeAbonnes") != null) { 
                abonnes = (ArrayList<Utilisateur>) request.getAttribute("listeAbonnes");
            }
            %>
            <div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<h1 id="fh5co-logo"><a href="connexion.jsp">JD<span>Connexion</span></a></h1>
					</div>
				</div>
			</header>		
		</div>
		<!-- end:fh5co-header -->
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/home-image.jpg);">
				<div class="desc animate-box">
					<div class="container">
						<div class="row">
							<div class="col-md-7">
								<div class="table-responsive">
                                                                    <table border='1'>
                                                                    <%
                                                                        for(Utilisateur u : abonnes) {
                                                                            out.println("<tr><td>" + u.getCodeu() + "</td><td>" +u.getNomu()+ "</td></tr>");
                                                                        }
                                                                    %>    
                                                                    </table>
                                                                </div>
                                                                <span><a href="pageadmin.jsp">Retour à la page d'accueil</a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
        <script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>  
        </body>
    </html>
</f:view>
