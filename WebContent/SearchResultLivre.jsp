<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="tn.itbs.bean.Livre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Détails du Livre</h2>

    <%
        Livre livre = (Livre) request.getAttribute("livre");

        if (livre != null) {
    %>
        <p><strong>Titre :</strong> <%= livre.getTitre() %></p>
        <p><strong>Prix :</strong> <%= livre.getPrix() %> </p>
        <p><strong>ID Magasin :</strong> <%= livre.getIdmagasin() %></p>
    <%
        } else {
    %>
        <p>Aucun livre trouvé.</p>
    <%
        }
    %>

</body>
</html>