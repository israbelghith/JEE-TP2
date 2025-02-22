<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>Ajouter Livre</h2>
    
    <form action="Servlet" method="GET">
        <label for="id">ID du livre :</label>
        <input type="number" id="id" name="id" required>
        <br><br>
        <label for="nom">Titre du livre :</label>
        <input type="text" id="titre" name="titre" required>
        <br><br>
        <label for="quantite">Prix :</label>
        <input type="number" id="prix" name="prix"  required>
        <br><br>
         <label for="id">ID du magasin :</label>
        <input type="number" id="idmagasin" name="idmagasin" required>
        <br><br>
         <input type="hidden" id="action" name="action"  value="AjoutLivre">
        <button type="submit">Ajouter</button>
    </form>

</body>
</html>