<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bien joué!</title>
    </head>
    <body>
        <hr>
            <h2>${nbJoueurs} 
                <c:choose>
                            <c:when test="${nbJoueurs<=1}">
                                joueur connecté
                            </c:when>
                            <c:otherwise>
                                joueurs connectés
                            </c:otherwise>
                </c:choose>
            </h2>
        <hr>

                
        <h2>Bravo! Tu as trouvé le juste nombre!</h2>

        <p>Nombre d'essais: ${nbGuesses}</p>
        
        <form method="POST">
            <input type="SUBMIT" name="action" value="Deconnexion"/>
            <input type="SUBMIT" name="action" value="Rejouer"/>
        </form>
    </body>
</html>
