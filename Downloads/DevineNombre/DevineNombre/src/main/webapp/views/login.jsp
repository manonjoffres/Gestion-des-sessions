<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine le Nombre </title>
    </head>
    <body>
        <h1>Bienvenue dans le jeu !</h1>
        <hr>
        <h2><c:choose>
                <c:when test="${empty nbJoueurs}">
                    0 joueur connecté
                </c:when>
                <c:otherwise>
                    ${nbJoueurs} <c:choose>
                            <c:when test="${nbJoueurs <= 1}">
                                joueur connecté
                            </c:when>
                            <c:otherwise>
                                joueurs connectés
                            </c:otherwise>
                        </c:choose>
                </c:otherwise>
            </c:choose></h2>
        <hr>
        <form method="POST">
		<label>Ton nom : <input name="playerName"></label>
		<input name="action" value="Connexion" type="SUBMIT">
	</form>
    </body>
</html>
